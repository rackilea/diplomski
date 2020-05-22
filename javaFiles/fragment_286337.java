package com.spark;

import static com.datastax.spark.connector.japi.CassandraJavaUtil.javaFunctions;
import static com.datastax.spark.connector.japi.CassandraJavaUtil.mapRowTo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import kafka.common.TopicAndPartition;
import kafka.message.MessageAndMetadata;
import kafka.serializer.StringDecoder;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.HasOffsetRanges;
import org.apache.spark.streaming.kafka.KafkaUtils;
import org.apache.spark.streaming.kafka.OffsetRange;

import scala.Tuple2;

public class KafkaChannelFetchOffset {
    public static void main(String[] args) {
        String topicName = "topicName";
        SparkConf sparkConf = new SparkConf().setAppName("name");
        JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, new Duration(2000));
        HashSet<String> topicsSet = new HashSet<String>(Arrays.asList(topicName));
        HashMap<TopicAndPartition, Long> kafkaTopicPartition = new HashMap<TopicAndPartition, Long>();
        Map<String, String> kafkaParams = new HashMap<>();
        kafkaParams.put("zookeeper.connect", "127.0.0.1");
        kafkaParams.put("group.id", "GROUP");
        kafkaParams.put("metadata.broker.list", "127.0.0.1");
        List<EventLog> eventLogList = javaFunctions(jssc).cassandraTable("test", "event_log", mapRowTo(EventLog.class))
                .select("topicName", "partion", "fromOffset", "untilOffset").where("topicName=?", topicName).collect();
        JavaDStream<String> kafkaOutStream = null;
        if (eventLogList == null || eventLogList.isEmpty()) {
            kafkaOutStream = KafkaUtils.createDirectStream(jssc, String.class, String.class, StringDecoder.class, StringDecoder.class, kafkaParams,
                    topicsSet).transform(new Function<JavaPairRDD<String, String>, JavaRDD<String>>() {
                @Override
                public JavaRDD<String> call(JavaPairRDD<String, String> pairRdd) throws Exception {
                    JavaRDD<String> rdd = pairRdd.map(new Function<Tuple2<String, String>, String>() {
                        @Override
                        public String call(Tuple2<String, String> arg0) throws Exception {
                            return arg0._2;
                        }
                    });
                    writeOffset(rdd, ((HasOffsetRanges) rdd.rdd()).offsetRanges());
                    return rdd;
                }
            });
        } else {
            for (EventLog eventLog : eventLogList) {
                kafkaTopicPartition.put(new TopicAndPartition(topicName, Integer.parseInt(eventLog.getPartition())),
                        Long.parseLong(eventLog.getUntilOffset()));
            }
            kafkaOutStream = KafkaUtils.createDirectStream(jssc, String.class, String.class, StringDecoder.class, StringDecoder.class, String.class,
                    kafkaParams, kafkaTopicPartition, new Function<MessageAndMetadata<String, String>, String>() {
                        @Override
                        public String call(MessageAndMetadata<String, String> arg0) throws Exception {
                            return arg0.message();
                        }
                    }).transform(new Function<JavaRDD<String>, JavaRDD<String>>() {

                @Override
                public JavaRDD<String> call(JavaRDD<String> rdd) throws Exception {
                    writeOffset(rdd, ((HasOffsetRanges) rdd.rdd()).offsetRanges());
                    return rdd;
                }
            });
        }
        // Use kafkaOutStream for further processing.
        jssc.start();
    }

    private static void writeOffset(JavaRDD<String> rdd, final OffsetRange[] offsets) {
        for (OffsetRange offsetRange : offsets) {
            EventLog eventLog = new EventLog();
            eventLog.setTopicName(String.valueOf(offsetRange.topic()));
            eventLog.setPartition(String.valueOf(offsetRange.partition()));
            eventLog.setFromOffset(String.valueOf(offsetRange.fromOffset()));
            eventLog.setUntilOffset(String.valueOf(offsetRange.untilOffset()));
            javaFunctions(rdd).writerBuilder("test", "event_log", null).saveToCassandra();
        }
    }
}