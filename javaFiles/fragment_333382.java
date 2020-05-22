String SCHEMA_TEMPLATE = "{" +
                        "\"type\": \"record\",\n" +
                        "    \"name\": \"schema\",\n" +
                        "    \"fields\": [\n" +
                        "        {\"name\": \"timeStamp\", \"type\": \"string\"},\n" +
                        "        {\"name\": \"temperature\", \"type\": \"double\"},\n" +
                        "        {\"name\": \"pressure\", \"type\": \"double\"}\n" +
                        "    ]" +
                        "}";
String PATH_SCHEMA = "s3a";
Path internalPath = new Path(PATH_SCHEMA, bucketName, folderName);
Schema schema = new Schema.Parser().parse(SCHEMA_TEMPLATE);
Configuration configuration = new Configuration();
AvroReadSupport.setRequestedProjection(configuration, schema);
ParquetReader<GenericRecord> = AvroParquetReader.GenericRecord>builder(internalPath).withConf(configuration).build();
GenericRecord genericRecord = parquetReader.read();

while(genericRecord != null) {
        Map<String, String> valuesMap = new HashMap<>();
        genericRecord.getSchema().getFields().forEach(field -> valuesMap.put(field.name(), genericRecord.get(field.name()).toString()));

        genericRecord = parquetReader.read();
}