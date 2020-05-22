@Bean
    public IntegrationFlow enrichJson() {
        return f -> f
                .transform(Transformers.fromJson(List.class))
                .split()
                .channel(c -> c.executor(Executors.newCachedThreadPool()))
                .enrich(e -> e
                        .requestPayloadExpression("payload.buyerId")
                        .requestChannel(getBuyerChannel())
                        .propertyExpression("buyer", "payload"))
                .aggregate()
                .transform(Transformers.toJson());
    }