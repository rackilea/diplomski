@Bean
@ServiceActivator(inputChannel = "input")
MessageHandler messageHandler() {
    BroadcasterMessageHandler handler new BroadcasterMessageHandler(myProcessor);
    handler.setOutputChannel(output());
    return handler;
}