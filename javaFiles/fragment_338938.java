Map<String, String> metadata = new Map<>();
map.put("key1", "value1");
map.put("key2", "value2");
ChargeCreateParams typedParams = ChargeCreateParams.builder()
      .setAmount(100L)
      .setCurrency("usd")
      .setSource("card_123")
      .putAllMetadata(metadata)
      .build();