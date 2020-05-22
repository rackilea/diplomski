// consumerConfig.put("value.deserializer", ByteBufferDeserializer.class)

ByteBuffer buf = record.value();
Deserializer d;

if (buf == null) {
    System.err.println("Tombstoned record");
} else if (buf.get() == 0x0) { // Check for Avro
    int schemaId = buf.getInt();  // If you wanted it

    d = new KafkaAvroDeserializer();        
    Map<String, String> config = new HashMap<>();
    config.put("schema.registry.url", "http://..."); // address to registry
    boolean isKey = false;
    d.configure(config, isKey);

    AvroValue v = d.deserialize(value);
    // TODO: Handle record
} else {
    try {
        d = new StringDeserializer();
        String s = d.deserialize(value);
        // TODO: Handle record
    } catch (Exception e) {
        e.printStackTrace();
    }

}