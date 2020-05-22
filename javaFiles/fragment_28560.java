void mapAppender(Map<String, String> result, Entry<String, JsonNode> node, List<String> names) {
    names.add(node.getKey());
    if (node.getValue().isTextual()) {
        String name = names.stream().collect(joining("."));
        result.put(name, node.getValue().asText());
    } else {
        node.getValue().fields()
            .forEachRemaining(nested -> mapAppender(result, nested, new ArrayList<>(names)));
    }
}