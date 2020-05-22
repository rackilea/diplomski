ResponseEntity<String> result = template.exchange("/query",
        HttpMethod.POST,
        new HttpEntity<>(params, headers),
        String.class);

    List<KafkaQueryResponse> array = new ArrayList<>();
    JsonFactory jsonFactory = new JsonFactory();
    try(BufferedReader br = new BufferedReader(new StringReader(result.getBody()))) {
        Iterator<KafkaQueryResponse> value = objectMapper.readValues(jsonFactory.createParser(br), KafkaQueryResponse.class);
        value.forEachRemaining(e -> {
            if (e.getRow() != null) {
                array.add(e);
            }
        });
    }
    array <----  this is the list of JSON objects