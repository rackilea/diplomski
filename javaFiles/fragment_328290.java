import org.apache.avro.file.DataFileStream;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerAvroByte {
private final static String BOOTSTRAP_SERVERS="<KAFKA_BROKER_HOST>:9092";
private static final String KEYSTORE_FILE_LOCATION = new File("kafka.client.keystore.jks").getAbsolutePath();
private static final String KEYSTORE_FILE_PASSWORD = "dhgfgspasswd";
private static final String SSL_KEY_PASSWORD = "dfsfjjkjdk";
private static final String TRUSTSTORE_FILE_LOCATION = new File("kafka.client.truststore.jks").getAbsolutePath();
private static final String TRUSTSTORE_FILE_PASSWORD = "UVctH3qsIbdwTc0B";

public static void main(String[] args) throws Exception
{
    Properties props = new Properties();
//Ref:https://github.com/janvanzoggel/apache-kafka/blob/master/src/main/java/nl/rubix/kafka/KafkaConsumerAvroByte.java

    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVERS);
    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,"test-group_yh1vdjcschkj2");
    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArrayDeserializer");

    props.put("security.protocol", "SSL");
    props.put("ssl.keystore.location", KEYSTORE_FILE_LOCATION);
    props.put("ssl.keystore.password", KEYSTORE_FILE_PASSWORD);
    props.put("ssl.key.password", SSL_KEY_PASSWORD);
    props.put("ssl.truststore.location", TRUSTSTORE_FILE_LOCATION);
    props.put("ssl.truststore.password", TRUSTSTORE_FILE_PASSWORD);
    props.put("serializer.class", "kafka.serializer.DefaultEncoder");
    props.put("max.poll.records","100");
    props.put("auto.offset.reset", "earliest");


    final Consumer<String, byte[]> consumer = new KafkaConsumer<>(props);

    consumer.subscribe(Collections.singletonList("TEST_Topic"));
    while (true) {
        final ConsumerRecords<String, byte[]> consumerRecords = consumer.poll(1000);
        // Decode
        consumerRecords.forEach(record1 -> {
            DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>();
            System.out.println("DECODE reader: " + reader);
            ByteArrayInputStream is = new ByteArrayInputStream(record1.value());
            System.out.println("DECODE is: " + is);
            try {
                DataFileStream<GenericRecord> dataFileReader = new DataFileStream<GenericRecord>(is, reader);
                System.out.println("DECODE dataFileReader: " + dataFileReader);

                GenericRecord record = null;
                while (dataFileReader.hasNext()) {
                    record = dataFileReader.next(record);
                    System.out.println(record.getSchema());
                    System.out.println(record.toString());
                }
            }  catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}  }