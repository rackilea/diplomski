public class DirectMessengerServer
{
  private final String[] serverArgs; // <-- added variable
  private static Socket socket;
  boolean keeyRunning = true;

  public DirectMessengerServer(String[] args)
  {
      // set the instance variable
      this.serverArgs = args;
  }


  public void run()
  {
      // access the serverArgs instance variable
      System.out.println(serverArgs[0]);
  }


//
// from the dirver program    
//
public static void main(String[] args)
{
    // after verifying the args as desired
    DirectMessengerServer server1 = new DirectMessengerServer(args);

}