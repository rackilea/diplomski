JsonNode tree = mapper.readTree(json);
for (JsonNode feature : tree.get("features")) {
    ((ObjectNode) feature).set("properties", mapper.createObjectNode());
}

String updatedJson = mapper.writeValueAsString(tree);