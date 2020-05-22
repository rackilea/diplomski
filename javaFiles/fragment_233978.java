public class Server {   
  private String data;

  public class ServerConnection {
     private int data; //shadows Server.data       

    public void connect() {
      //access Server.data of the Server instance associated with this instance
      Server.this.data = "xyz"; //Note that you also have write access, so that might be dangerous
      ...
    }
  }
}