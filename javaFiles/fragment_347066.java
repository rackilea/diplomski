public class server {
  private static int port = 5000;

  public server(int yourParameter) {
    /*...*/
    service = new ServerSocket(port++);
    /*...*/
  }
}