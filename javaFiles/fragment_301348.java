public TreeMap<BigDecimal, BigDecimal> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

    ObjectCodec oc = jsonParser.getCodec();
    List<Map.Entry<BigDecimal, BigDecimal>> input = oc.readValue(jsonParser, new TypeReference<List<Map.Entry<BigDecimal, BigDecimal>>>(){});

    Map<BigDecimal, BigDecimal> intermediateMap = input.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    return new TreeMap<>(intermediateMap);
}