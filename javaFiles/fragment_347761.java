public class Start
{
  public static void main(String[] args)
  {
    Start myStart = new Start();
    myStart.doIt();
  }

  private void doIt()
  {
    ClientThread clienThread= new ClientThread();
    new Thread(clienThread).start();

    ThreadPooledServer server = new ThreadPooledServer(6000);
    new Thread(server).start();
  }
}