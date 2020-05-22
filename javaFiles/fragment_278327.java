public class Websock {
  private static class Adapter extends WebSocketAdapter {
    @Override
    public void onWebSocketConnect(Session sess) {
      System.out.print("client connected");
    }
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    WebAppContext context = new WebAppContext("webapp", "/");
    context.getServletHandler().setEnsureDefaultServlet(false); // may or may not be needed.

    ContextHandlerCollection handlerCollection = new ContextHandlerCollection();
    handlerCollection.addHandler(context);
    handlerCollection.addHandler(createWebsocketHandler());

    server.setHandler(handlerCollection);

    server.start();
  }

  private static ContextHandler createWebsocketHandler() {
    ContextHandler contextHandler = new ContextHandler("/ws");
    contextHandler.setAllowNullPathInfo(true); // disable redirect from /ws to /ws/

    final WebSocketCreator webSocketcreator = new WebSocketCreator() {
      public Object createWebSocket(ServletUpgradeRequest request,
          ServletUpgradeResponse response) {
        return new Adapter();
      }
    };

    Handler webSocketHandler = new WebSocketHandler() {
      public void configure(WebSocketServletFactory factory) {
        factory.setCreator(webSocketcreator);
      }
    };

    contextHandler.setHandler(webSocketHandler);
    return contextHandler;
  }
}