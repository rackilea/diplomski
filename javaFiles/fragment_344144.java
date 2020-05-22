String json = "{ \"query\": { \"pageids\": [ \"736\" ], \"pages\": { \"736\": { \"pageid\": 736, \"ns\": 0, \"title\": \"Albert Einstein\", \"contentmodel\": \"wikitext\", \"pagelanguage\": \"en\", \"touched\": \"2014-01-05T03:14:23Z\", \"lastrevid\": 588780054, \"counter\": \"\", \"length\": 106159 } } } }";
ObjectMapper mapper = new ObjectMapper();
JsonNode node =mapper.readTree(json);

node = node.get("query").get("pages");

Map<String, Page> pages = mapper.readValue(node.traverse(), new TypeReference<Map<String, Page>>() {
});

System.out.println(pages);