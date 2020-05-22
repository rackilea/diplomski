ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new JavaTimeModule());

JsonNode node = mapper.readTree(json).get("bpi");

ObjectReader reader = mapper.readerFor(new TypeReference<Map<LocalDate, Double>>() {});
Map<LocalDate, Double> bpi = reader.readValue(node);