@Test
public void testValidMessage() throws Exception {
    Document doc = XmlTestUtil.getDocumentForString("<!DOCTYPE greeting SYSTEM \"greeting.dtd\"><greeting>hello</greeting>");
    GenericMessage<Document> docMessage = new GenericMessage<Document>(doc);
    PollableChannel validChannel = ac.getBean("validOutputChannel", PollableChannel.class);
    MessageChannel inputChannel = ac.getBean("inputChannelA", MessageChannel.class);
    inputChannel.send(docMessage);
    assertNotNull(validChannel.receive(100));
}