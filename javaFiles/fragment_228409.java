@Bean
public MyPojo myPojo() {
    return new MyPojo();
}

@MessageEndpoint
public static class MyPojo {

    @ServiceActivator(inputChannel = "archiveFile.input")
    public Message<File> myMethod (File inputFile){
        Map<String, Object> contextHeader = new HashMap<String, Object>();
        return new GenericMessage<File>(inputFile, contextHeader);
    }

}