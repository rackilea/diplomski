public class ServerConnection {
  private Server server;

  public ServerConnection(Server s) {
    server = s;
  }

  public void connect() {
    String serverData = server.getData();
    ...
  }
}