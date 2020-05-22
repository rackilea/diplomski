public class MyRequest extends Request
{
  private MyFinish _finish;
  public MyRequest(MyFinish finish)
  {
    _finish=finish;
  }

  public void setFinish(MyFinish finish)
  {
     _finish=finish;
  }

  @Override
  public void onFinish(String resp)
  {
    _finish.doFinish(resp);    
  }
}

public interface MyFinish
{
  public void doFinish(String resp);
}