@ServiceActivator(inputChannel="inputChannel")
@Bean(name="test")
public MessageHandler httpout() {
    HttpRequestExecutingMessageHandler handler = new ...
    ...
    return handler;
}