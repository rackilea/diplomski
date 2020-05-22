Map test = ImmutableSettings.builder()
            .loadFromSource("{\n" +
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
                    "}").build().getAsMap();
    System.out.println("test = " + test);