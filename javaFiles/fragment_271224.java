@Bean
    public IntegrationFlow routerTwoSubFlows() {
        return f -> f
                .split()
                .<Integer, Boolean>route(p -> p % 2 == 0, m -> m
                        .subFlowMapping("true", sf -> sf.<Integer>handle((p, h) -> p * 2))
                        .subFlowMapping("false", sf -> sf.<Integer>handle((p, h) -> p * 3)))
                .aggregate()
                .channel(c -> c.queue("routerTwoSubFlowsOutput"));
    }