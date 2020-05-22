@Service
public class SomeService {
   public Map handle(Map dataHolder) {...}
}

@Service
public class OtherSerice {
  @Inject SomeService serv1;
  Map theDataNotSafe = new HashMap();

  public Map func() {
    Map theData = new HashMap();
    serv1.handle(theData); // thread safe, 
    serv1.handle(theDataNotSafe); // not thread safe
  }
}