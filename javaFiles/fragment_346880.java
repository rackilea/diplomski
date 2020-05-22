@Test
public void testPubSubChannel() throws InterruptedException {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("pubSubChannelConfig.xml", getClass());
    MessageChannel channel = (MessageChannel) context.getBean("pubSubChannel");
    for (int i = 0; i < 10; i++) {
        channel.send(new GenericMessage<Integer>(i));
    }
    Thread.sleep(10000);
    context.close();
}