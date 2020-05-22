@Bean
public IntegrationFlow server(PollableChannel requests, MessageChannel replies) {
    return IntegrationFlows.from(Tcp.inboundGateway(Tcp.netServer(1234))
                .replyChannel(replies))
            .transform(Transformers.objectToString())
            .channel(requests)
            .get();
}