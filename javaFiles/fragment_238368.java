public class WebSocketClient {
  private boolean pushLock;
  private Gson gson;
  private Queue<CacheContainer> queue = new ConcurrentLinkedQueue<>();

  WebSocketClient(MyQuery query, CacheHandler cacheHandler) {
    pushLock = true;
    this.gson = GsonFactory.getGson(query, cacheHandler);
  }

  public synchronized boolean isPushLock() {
    return pushLock;
  }

  public synchronized void pushUnlock() {
    pushLock = false;
  }

  public Gson getGson() {
    return gson;
  }

  public Queue<CacheContainer> getQueue() {
    return queue;
  }

  public boolean hasBackLog() {
    return !queue.isEmpty();
  }
}

public class MyConnectionCallback implements WebSocketConnectionCallback {

  private final Map<WebSocketChannel, WebSocketClient> clients = new ConcurrentHashMap<>();
  private final BlockingQueue<CacheContainer> messageQueue = new LinkedBlockingQueue<>();

  private final Gson queryGson = new GsonBuilder().disableHtmlEscaping().create();

  private final CacheHandler cacheHandler;

  MyConnectionCallback(CacheHandler cacheHandler) {
    this.cacheHandler = cacheHandler;
    Thread pusherThread = new Thread(() -> {
      boolean hasPushLock = false;
      while (true) {
        if (messageQueue.isEmpty() && hasPushLock) hasPushLock = pushToAllClients(null);
        else hasPushLock = pushToAllClients(messageQueue.take());
      }
    }, "PusherThread");
    pusherThread.start();
  }

  @Override
  public void onConnect(WebSocketHttpExchange webSocketHttpExchange, WebSocketChannel webSocketChannel) {
    webSocketChannel.getReceiveSetter().set(new AbstractReceiveListener() {
      @Override
      protected void onFullTextMessage(WebSocketChannel channel, BufferedTextMessage message) throws IOException {
        MyQuery query = new MyQuery(queryGson.fromJson(message.getData(), QueryJson.class));
        WebSocketClient clientConfig = new WebSocketClient(query, cacheHandler);
        clients.put(webSocketChannel, clientConfig);
        push(webSocketChannel, clientConfig.getGson(), cacheHandler.getCache());
        clientConfig.pushUnlock();
        }
    });
    webSocketChannel.resumeReceives();
  }

  void putMessage(CacheContainer message) {
    messageQueue.put(message);
  }

  private synchronized void push(WebSocketChannel webSocketChannel, Gson gson, CacheContainer message) throws IOException {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
      JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(baos, StandardCharsets.UTF_8))) {
      gson.toJson(message, CacheContainer.class, jsonWriter);
      jsonWriter.flush();
      if (baos.size() > 2) {
        WebSockets.sendText(ByteBuffer.wrap(baos.toByteArray()), webSocketChannel, null);
      }
    }
  }

  private synchronized boolean pushToAllClients(CacheContainer message) {
    AtomicBoolean hadPushLock = new AtomicBoolean(false);
    Set<WebSocketChannel> closed = new HashSet<>();

    clients.forEach((webSocketChannel, clientConfig) -> {
      if (webSocketChannel.isOpen()) {
        if (clientConfig.isPushLock()) {
          hadPushLock.set(true);
          clientConfig.getQueue().add(message);
        } else {
          try {
            if (clientConfig.hasBackLog())
              pushBackLog(webSocketChannel, clientConfig);
            if (message != null)
              push(webSocketChannel, clientConfig.getGson(), message);
          } catch (Exception e) {
            closeChannel(webSocketChannel, closed);
          }
        }
      } else {
        closed.add(webSocketChannel);
      }
    });

    closed.forEach(clients::remove);
    return hadPushLock.get();
  }

  private void pushBackLog(WebSocketChannel webSocketChannel, WebSocketClient clientConfig) throws IOException {
    while (clientConfig.hasBackLog()) {
      push(webSocketChannel, clientConfig.getGson(), clientConfig.getQueue().poll());
    }
  }

  private void closeChannel(WebSocketChannel channel, Set<WebSocketChannel> closed) {
    closed.add(channel);
    channel.close();
  }
}