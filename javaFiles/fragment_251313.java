public class gameRunner {
  public static ArrayList<object> objects = new ArrayList<object>();
  public static player[] players = new player[1000];

  public server gameServer;

  /* ... */
  Runnable sendPlayerPackets = new Runnable () {
    public void run () {
        while(true) {
            gameServer.sendPacket(gameRunner.players[0].packet); //<<<----
            }
    }
};