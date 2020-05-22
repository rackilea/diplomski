public class SocketHandler implements Runnable
{
  private Socket socket;

  public SocketHandler(String host, int port)
  {
    socket = new Socket(host, port);
  }

  public void run()
  {
    //Do the comms to the remote server
  }
}