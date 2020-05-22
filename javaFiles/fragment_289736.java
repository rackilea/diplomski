public static final Map<TopicPartition, Long> offsets = Map.of(new TopicPartition("testtopic", 0), 5L);

public static void main(String args[]) {
    Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    try (Consumer<String, String> consumer = new KafkaConsumer<>(props)) {

        consumer.subscribe(Collections.singletonList("testtopic"), new ConsumerRebalanceListener() {

            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {}

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
                System.out.println("Assigned " + partitions);
                for (TopicPartition tp : partitions) {
                    OffsetAndMetadata oam = consumer.committed(tp);
                    if (oam != null) {
                        System.out.println("Current offset is " + oam.offset());
                    } else {
                        System.out.println("No committed offsets");
                    }
                    Long offset = offsets.get(tp);
                    if (offset != null) {
                        System.out.println("Seeking to " + offset);
                        consumer.seek(tp, offset);
                    }
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println("Calling poll");
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100L));
            for (ConsumerRecord<String, String> r : records) {
                System.out.println("record from " + r.topic() + "-" + r.partition() + " at offset " + r.offset());
            }
        }
    }
}