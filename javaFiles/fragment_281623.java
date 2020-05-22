String payload = "{\"order\": { \"date\": 1531380888 } }";

ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.USE_LONG_FOR_INTS, true);

Configuration conf = Configuration.builder()
    .jsonProvider(new JacksonJsonProvider(objectMapper))
    .build();
Object rawJson = conf.jsonProvider().parse(payload);
Long orderDate = JsonPath.read(rawJson, "$.order.date");

assertThat(orderDate, is(1531380888L));