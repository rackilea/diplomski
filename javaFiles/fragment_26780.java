private static void parse(String json) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonParser parser = new JsonFactory().createJsonParser(json);
    while (parser.nextToken() != JsonToken.END_OBJECT) {
        String tok = parser.getCurrentName();
        Page p = new Page();
        if ("address".equals(tok)) {
            parser.nextToken();
            p.setAddress(parser.getText());
        }
        if ("links".equals(tok)) {
            parser.nextToken();
            ArrayNode node = objectMapper.readTree(parser);
            Iterator<JsonNode> iterator = node.elements();
            String[] array = new String[node.size()];
            for (int i = 0; i < node.size(); i++) {
                if (iterator.hasNext()) {
                    array[i] = iterator.next().asText();
                }
            }
            p.setLinks(array);
        }
        net.add(p);
    }
}