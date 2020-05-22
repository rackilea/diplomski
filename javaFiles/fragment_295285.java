private void addKeys(String currentPath, JsonNode jsonNode, Map<String, String> map, List<Integer> suffix) {
    if (jsonNode.isObject()) {
        ObjectNode objectNode = (ObjectNode) jsonNode;
        Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
        String pathPrefix = currentPath.isEmpty() ? "" : currentPath + "-";

        while (iter.hasNext()) {
            Map.Entry<String, JsonNode> entry = iter.next();
            addKeys(pathPrefix + entry.getKey(), entry.getValue(), map, suffix);
        }
    } else if (jsonNode.isArray()) {
        ArrayNode arrayNode = (ArrayNode) jsonNode;

        for (int i = 0; i < arrayNode.size(); i++) {
            suffix.add(i + 1);
            addKeys(currentPath, arrayNode.get(i), map, suffix);

            if (i + 1 <arrayNode.size()){
                suffix.remove(arrayNode.size() - 1);
            }
        }

    } else if (jsonNode.isValueNode()) {
        if (currentPath.contains("-")) {
            for (int i = 0; i < suffix.size(); i++) {
                currentPath += "-" + suffix.get(i);
            }

            suffix = new ArrayList<>();
        }

        ValueNode valueNode = (ValueNode) jsonNode;
        map.put(currentPath, valueNode.asText());
    }
}