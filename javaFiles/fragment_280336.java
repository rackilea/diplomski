static { 
    kafkaProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "smallest"); 
    kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG, "CustomerCountryGroup1"); 
    kafkaProps.put("zookeeper.connect", "localhost:2181"); 
    kafkaProps.put("schema.registry.url", "http://localhost:8081"); 
    kafkaProps.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true); 
}

public static void infiniteConsumer() throws IOException { 

VerifiableProperties properties = new VerifiableProperties(kafkaProps); 
StringDecoder keyDecoder = new StringDecoder(properties); 
KafkaAvroDecoder valueDecoder = new KafkaAvroDecoder(properties); 

Map<String, Integer> topicCountMap = new HashMap<>(); 
topicCountMap.put("BrandNewTopics", 1); 

ConsumerConnector consumer = createJavaConsumerConnector(new kafka.consumer.ConsumerConfig(kafkaProps)); 
Map<String, List<KafkaStream<String, Object>>> consumerMap = consumer.createMessageStreams(topicCountMap, keyDecoder, valueDecoder); 

KafkaStream stream = consumerMap.get("BrandNewTopics").get(0); 
ConsumerIterator it = stream.iterator(); 

while (it.hasNext()) { 
    MessageAndMetadata messageAndMetadata = it.next(); 
    String key = (String) messageAndMetadata.key(); 
    GenericRecord record = (GenericRecord) messageAndMetadata.message(); 
    Customer customer = (Customer) SpecificData.get().deepCopy(Customer.SCHEMA$, record); 
    System.out.println("Key: " + key); 
    System.out.println("Value: " + customer); 
}