public class Server {
  private final SocketFactory socketFactory;
  private final ThreadFactory threadFactory;

  public Server() {
    this(new SocketFactory(), new ThreadFactory());
  }

  Server(SocketFactory socketFactory, ...
    this.socketFactory = socketFactory...

public void startServer() throws IOException
{
    ServerSocket ss = socketFactory.createSocketFor(portNum);
    while(true)
    {
        Socket s = ss.accept();
        Thread t = threadFactory.newThreadFor(new ConnectionHandler(s));
        t.start();
    }
}