public static void main(String[] args) {
    int i = 0;
    //List<String> topics = new ArrayList<>();
    List<String> topics = Collections.singletonList("test_topic");
    //topics.add("test_topic");
    Properties consumerConfigurations = new Properties();
    consumerConfigurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    consumerConfigurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    consumerConfigurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    consumerConfigurations.put(ConsumerConfig.GROUP_ID_CONFIG, "TestId");

    Consumer<String, String> consumer = new KafkaConsumer<>(consumerConfigurations);
    consumer.subscribe(topics);

    Runtime.getRuntime().addShutdownHook(new Thread()
    {
      public void run() {
        consumer.wakeup();
      }
    });

    try {
      while (true) {
        ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);
        Iterator<ConsumerRecord<String, String>> iterator = consumerRecords.iterator();
        while (iterator.hasNext()) {
          i++;
          ConsumerRecord<String, String> consumerRecord = iterator.next();
          String key = consumerRecord.key();
          String value = consumerRecord.value();
          if (key == "exit" || value == "exit")
            break;
          System.out.println("Key=" + key + "\tValue=" + value);
        }
        System.out.println("Messages processed = " + Integer.toString(i));
      }
    } catch (WakeupExection e) {
      // Do Nothing
    } finally {
      consumer.close();
    }
  }
}