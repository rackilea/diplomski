public class Client
    implements AutoCloseable
{
  // Any other ThreadPool can be used as well
  private ExecutorService es = Executors.newCachedThreadPool();

  // port this client shall listen on
  private int port;

  // Name of the client
  private String name;

  // indicates that a connection is ongoing
  private boolean isConnected = false;

  // the socket the Client is currently connected with
  private Socket activeConenctionSocket;

  // The ServerSocket which will be listening for any incoming connection
  private ServerSocket listener;

  // The socket which has been accepted by the ServerSocket
  private Future<Socket> acceptedSocket;

  /**
   * @param port Port number by which this client shall be accessed.
   * @param name The name of this Client.
   */
  public Client( int port, String name )
  {
    this.port = port;
    this.name = name;
    this.listener = createListeningSocket();
    startListening();
  }

  private ServerSocket createListeningSocket()
  {

    ServerSocket temp = null;
    try
    {
      temp = new ServerSocket( port );
    }
    catch ( IOException e )
    {
      e.printStackTrace();
    }

    return temp;
  }

  private void startListening()
  {
    if ( !isConnected )
    {
      listener = createListeningSocket();
      acceptedSocket = es.submit( new ServAccept( listener ) );
    }
  }

  /**
   * Attempts to connect to any other socket specified by the hostname and the targetport.
   * 
   * @param host The hostname of the target to connect.
   * @param targetport The port of the target.
   */
  public void connect( String host, int targetport )
  {
    isConnected = true;
    try
    {
      activeConenctionSocket = new Socket( InetAddress.getByName( host ), targetport );
    }
    catch ( IOException e )
    {
      e.printStackTrace();
    }

    try
    {
      listener.close();
    }
    catch ( IOException e )
    {
      // this will almost certainly throw an exception but it is intended.
    }
  }

  @Override
  public void close() throws Exception
  {
    // close logic (can be rather nasty)
  }
}