public class ConsumerManager  {

    static String brokers = "<kafka_host>:9092";
    private ExecutorService executor;
    String kafkaPrefix = "proc_422_26952";
    private final Boolean isAsync = false;
    static String TOPIC; //"proc_69686_61";//" "qa_69313_2";

    public ConsumerManager(String topicName) {

        TOPIC = topicName;
        Properties props = new Properties();

        props.put("bootstrap.servers", brokers);
        props.put("group.id", "CageConsumerGroupIO");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("max.poll.records", "500");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Arrays.asList(TOPIC));
        System.out.println("Subscribed to topic " + TOPIC);
        int i = 0;

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);

            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
                System.out.println(record.value());
            }


        }
    }