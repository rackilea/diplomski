public interface Request {
  public void doProcess(String name,String age);
}

@Transactional
public class RequestImpl implements Request{
  public void doProcess(String name,String age){
    // do what you want
  }
}