@Bean
    public IntegrationFlow pollingAdapterFlow(EntityManagerFactory entityManagerFactory) {
        return IntegrationFlows
                .from(Jpa.inboundAdapter(entityManagerFactory)
                                .entityClass(StudentDomain.class)
                                .maxResults(1)
                                .expectSingleResult(true),
                        e -> e.poller(p -> p.trigger(new OnlyOnceTrigger())
                                .transactional()))
                .channel(c -> c.queue("pollingResults"))
                .get();
    }