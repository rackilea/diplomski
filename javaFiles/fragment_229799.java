Properties props = new Properties();
props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, zkConnection);
props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

byte[] byteData = null;
File myInputFile = new File(...);
try (InputStream inputStream = new FileInputStream(myInputFile)) {
    byteData = IOUtils.toByteArray(inputStream);
}

try (KafkaProducer<String, byte[]> producer = new KafkaProducer<String, byte[]>(props)) {
    producer.send(new ProducerRecord<String, byte[]>(topic, byteData));
}