public class pacioWebSocketListener extends WebSocketListener {

   MessageListener msgListener; 

  private static final int NORMAL_CLOSURE_STATUS = 1000;
  WebSocket ws;


  public pacioWebSocketListener(MessageListener listener){
       this.msgListener = listener;
  }

  // interface
  public interface MessageListener{
     void onMessageReceived(String message)
  }


  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    super.onOpen(webSocket, response);
    Log.v(TAG,"onOpen");
  }

  @Override
  public void onMessage(WebSocket webSocket, String message) {
    super.onMessage(webSocket, message);

    // When a new Message arrives , call the MessageListener.onMessageReceived
    msgListener.onMessageReceived(message);
  }