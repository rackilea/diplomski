@Bean
    public IntegrationFlow publishSubscribeFlow() {
        return flow -> flow
                .publishSubscribeChannel(s -> s
                        .applySequence(true)
                        .subscribe(f -> f
                                .handle((p, h) -> "Hello")
                                .channel("publishSubscribeAggregateFlow.input"))
                        .subscribe(f -> f
                                .handle((p, h) -> "World!")
                                .channel("publishSubscribeAggregateFlow.input"))
                );
    }

    @Bean
    public IntegrationFlow publishSubscribeAggregateFlow() {
        return flow -> flow
                .aggregate(a -> a.outputProcessor(g -> g.getMessages()
                        .stream()
                        .<String>map(m -> (String) m.getPayload())
                        .collect(Collectors.joining(" "))))
                .channel(c -> c.queue("subscriberAggregateResult"));
    }