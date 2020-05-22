@Bean
public PublishSubscribeChannel outputChannel() {
    return MessageChannels.publishSubscribe()
        .interceptor(new WireTap(loggerChannel()))
        .get();
}