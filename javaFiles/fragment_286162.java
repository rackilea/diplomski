Map<String, Map<String, Double>> map = new HashMap<>();

    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(new File("path_to_json_file"));
    JsonNode data = node.get("Time Series (Daily)");

    Iterator<String> iterator = data.fieldNames();
    while (iterator.hasNext()) {
        String date = iterator.next();
        JsonNode value = data.get(date);

        Map<String, Double> priceMap = new HashMap<>();
        Iterator<String> itr = value.fieldNames();
        while(itr.hasNext()){
            String param = itr.next();
            JsonNode price = value.get(param);

            priceMap.put(param.replaceAll(" ", "").split("\\.")[1], price.asDouble());
        }
        map.put(date, priceMap);
    }
    System.out.println(map);
}