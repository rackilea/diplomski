public class ServAccept
    implements Callable<Socket>
{
  ServerSocket serv;

  public ServAccept( ServerSocket sock )
  {
    this.serv = sock;
  }

  @Override
  public Socket call() throws Exception
  {
    return serv.accept();
  }

}