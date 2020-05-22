@Bean
@ServiceActivator(inputChannel = "fileInputChannel")
public MessageHandler fileReceiver() {
    FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("outDir"));
    handler.setFileExistsMode(FileExistsMode.REPLACE);
    handler.setDeleteSourceFiles(true);
    handler.setExpectReply(false);

    handler.setAutoCreateDirectory(true);
    return handler;
}