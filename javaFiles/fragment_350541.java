Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
        .options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();
ArrayNode jsonErrorMessageNodes = JsonPath.using(conf).parse(json).read("$..errors[*]");

for (Iterator<JsonNode> it = jsonErrorMessageNodes.elements() ; it.hasNext() ; ) {
    JsonNode node = it.next();
    for (Iterator<String> it1 = node.fieldNames(); it1.hasNext(); ) {
        final String s = it1.next();
        System.out.println(s);
    }
}