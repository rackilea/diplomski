@Bean
@ServiceActivator(inputChannel = "input")
public MessageHandler fileOutBoundGateway() {
    FileWritingMessageHandler gateway = new FileWritingMessageHandler(new File("myDir"));
    gateway.setDeleteSourceFiles(true);
    gateway.setAutoCreateDirectory(true);
    gateway.setOutputChannel(outputChannel());
    return gateway;
}