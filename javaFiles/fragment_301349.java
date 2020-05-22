public Map<SecretClass, BigDecimal> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

    ObjectCodec oc = jsonParser.getCodec();
    List<Map.Entry<SecretClass, BigDecimal>> input = oc.readValue(jsonParser, new TypeReference<List<Map.Entry<SecretClass, BigDecimal>>>(){});

    return input.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}