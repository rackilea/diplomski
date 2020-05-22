CreateIndexRequest request = new CreateIndexRequest("twitter"); 
request.mapping("tweet", 
    "  {\n" +
    "    \"tweet\": {\n" +
    "      \"properties\": {\n" +
    "        \"message\": {\n" +
    "          \"type\": \"text\"\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +
    "  }", 
    XContentType.JSON);
CreateIndexResponse createIndexResponse = client.indices().create(request);