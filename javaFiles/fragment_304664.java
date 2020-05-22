Configuration conf = Configuration.builder()
       .mappingProvider(new JacksonMappingProvider())
       .jsonProvider(new JacksonJsonProvider())
       .build();
Object rawJson = conf.jsonProvider().parse(payload);
Object rawListPrice = JsonPath.read(rawJson, "$.total");
double listPrice;
if (rawListPrice instanceOf Double) {
    listPrice = (Double) rawListPrice;
} else if (rawListPrice instanceOf Integer) {
    listPrice = (Integer) rawListPrice;
} else {
    throw new MyRuntimeException("unexpected type: " + rawListPrice.getClass());
}