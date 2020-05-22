Iterator<Entry<String, JsonNode>> iter = rootNode.fields();
while (iter.hasNext()) {
    Entry<String, JsonNode> entry = iter.next();
    System.out.println("key: " + entry.getKey());
    System.out.println("value: " + entry.getValue());
}