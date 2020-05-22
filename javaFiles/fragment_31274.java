@Autowired
private SubscribableChannel errorChannel;


@Test
public void test() {
    SettableListenableFuture<Message<?>> messageFuture = new SettableListenableFuture<>();
    this.errorChannel.subscribe((message) -> messageFuture.set(message));
    helloWorldChannel.send(MessageBuilder.withPayload("1,2,3,4,6").build());
    Message<?> messageToAssert = messageFuture.get(10, TimeUnit.SECONDS);
    ...
}