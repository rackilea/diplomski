@Bean
public IntegrationFlow channelAdapterFlow() {
    return IntegrationFlows.from(new MyMessageSource(), 
                e -> e.id("myInboundAdapter").autoStartup(false).poller(p -> p.fixedDelay(100)))
            .channel(adapterOutputChanel())
            .get();
}