public interface DataReceiver extends ErrorInterface {
  public void dataReceived(Data d); 
  //or just scrap the ErrorInterface all together and make these into 1 interface
}

public class AbstractIFAdapter<T extends ErrorInterface> implements DataReceiver {
  private T target;
  public AbstractIFAdapter(T target) { this.target = target);
  public void onError(String reason) { target.onError(reason); }
  protected T getTarget() { return target; }
}

public class IF1Adapter extends AbstractIFAdapter<IF1> {
  public IF1Adapter(IF1 target) { super(target); }
  public dataReceived(Data d) { getTarget().dataReceived1(d); }
}

public class IF2Adapter extends AbstractIFAdapter<IF2> {
  public IF2Adapter(IF2 target) { super(target); }
  public dataReceived(Data d) { getTarget().dataReceived2(d); }
}