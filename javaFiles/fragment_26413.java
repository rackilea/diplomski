private static final Logger log = LoggerFactory.getLogger(MessageService.class);

  private List<String> messageStore = new LinkedList<>();
  private Channel openedChannel;

  public void sendToTCP(final String message) {
    log.info("[Service] - Sending Message over TCP Channel --> {}", message);
    log.info("[Service] - Channel is Active? {}", this.openedChannel.isActive());
    log.info("[Service] - Channel is Open? {}", this.openedChannel.isOpen());
    log.info("[Service] - Channel is Writeble? {}", this.openedChannel.isWritable());

    this.openedChannel.write(message);
    this.openedChannel.flush();
  }

  @Handler
  public void receiveFromTCP(final Exchange exchange) {
    this.openedChannel = exchange.getProperty(NettyConstants.NETTY_CHANNEL, Channel.class);
    final String messageFromTcp = exchange.getIn().getBody(String.class);
    log.info("[Service] - Message Received from TCP Channel --> {}", messageFromTcp);
    this.messageStore.add(messageFromTcp);
  }