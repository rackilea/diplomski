final Properties properties = new Properties();
 properties.put("metadata.broker.list","localhost:9092");
 properties.put("serializer.class", "kafka.serializer.StringEncoder");

 final JavaDStreamKafkaWriter<String> writer =
        JavaDStreamKafkaWriterFactory.fromJavaDStream(JavaDStream);

  writer.writeToKafka(properties, msg -> new KeyedMessage<>(TOPIC,msg));