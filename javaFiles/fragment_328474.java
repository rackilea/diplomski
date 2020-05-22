@Test
    public void createIndexTemp() throws IOException {
        String index = "so_q_26949195";

        String settingsAsString = "{\n" +
                "  \"settings\": {\n" +
                "    \"number_of_shards\": 3,\n" +
                "    \"analysis\": {\n" +
                "      \"filter\": {\n" +
                "        \"keyword_search\": {\n" +
                "          \"type\":     \"edge_ngram\",\n" +
                "          \"min_gram\": 3,\n" +
                "          \"max_gram\": 15\n" +
                "        }\n" +
                "      },\n" +
                "      \"analyzer\": {\n" +
                "        \"keyword\": {\n" +
                "          \"type\":      \"custom\",\n" +
                "          \"tokenizer\": \"whitespace\",\n" +
                "          \"filter\": [\n" +
                "            \"lowercase\",\n" +
                "            \"keyword_search\"\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Map settingsAsMap = ImmutableSettings.builder()
                .loadFromSource(settingsAsString).build().getAsMap();

        CreateIndex createIndex = new CreateIndex.Builder(index)
                .settings(settingsAsString)
                .build();

        JestResult result = client.execute(createIndex);
        assertTrue(result.getErrorMessage(), result.isSucceeded());

        GetSettings getSettings = new GetSettings.Builder().addIndex(index).build();
        result = client.execute(getSettings);
        assertTrue(result.getErrorMessage(), result.isSucceeded());
        System.out.println("SETTINGS SENT AS STRING settingsResponse = " + result.getJsonString());

        Analyze analyze = new Analyze.Builder()
                .index(index)
                .analyzer("keyword")
                .source("Expecting many tokens")
                .build();
        result = client.execute(analyze);
        assertTrue(result.getErrorMessage(), result.isSucceeded());
        Integer actualTokens = result.getJsonObject().getAsJsonArray("tokens").size();
        assertTrue("Expected multiple tokens but got " + actualTokens, actualTokens > 1);

        analyze = new Analyze.Builder()
                .analyzer("keyword")
                .source("Expecting single token")
                .build();
        result = client.execute(analyze);
        assertTrue(result.getErrorMessage(), result.isSucceeded());
        actualTokens = result.getJsonObject().getAsJsonArray("tokens").size();
        assertTrue("Expected single token but got " + actualTokens, actualTokens == 1);

        admin().indices().delete(new DeleteIndexRequest(index)).actionGet();

        createIndex = new CreateIndex.Builder(index)
                .settings(settingsAsMap)
                .build();

        result = client.execute(createIndex);
        assertTrue(result.getErrorMessage(), result.isSucceeded());

        getSettings = new GetSettings.Builder().addIndex(index).build();
        result = client.execute(getSettings);
        assertTrue(result.getErrorMessage(), result.isSucceeded());
        System.out.println("SETTINGS AS MAP settingsResponse = " + result.getJsonString());

        analyze = new Analyze.Builder()
                .index(index)
                .analyzer("keyword")
                .source("Expecting many tokens")
                .build();
        result = client.execute(analyze);
        assertTrue(result.getErrorMessage(), result.isSucceeded());
        actualTokens = result.getJsonObject().getAsJsonArray("tokens").size();
        assertTrue("Expected multiple tokens but got " + actualTokens, actualTokens > 1);
    }