ChargeCreateParams typedParams = ChargeCreateParams.builder()
      .setAmount(100)
      .setCurrency("usd")
      .setSource("card_123")
      .putMetadata("key1", "value1")
      .putMetadata("key2", "value2")
      .build();