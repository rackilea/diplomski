ObjectMapper mapper = new ObjectMapper();
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    JsonNode node = mapper.readTree(new URL(url));
    node = node.get("duObjects");

    TypeReference<List<Dataset>> typeRef = new TypeReference<List<Dataset>>() {
    };
    List<Dataset> list = mapper.readValue(node.traverse(), typeRef);
    for (int i = 0; i < list.size(); i++) {
        Dataset dataSet = list.get(i);
        System.out.println(dataSet.getName());
    }