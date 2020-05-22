import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class DummyWS {

  public static void main(String[] args) {
    final String url= "http://localhost:8888/Dummy";
    final Endpoint endpoint= Endpoint.create(new DummyWS());
    endpoint.publish(url);
  }

  public void putData(final String value) {
    System.out.println("value: "+value);
  }

  public void doSomething() {
    System.out.println("doing nothing");
  }


  @WebMethod(exclude=true)
  public void myInternalMethod() {
    System.out.println("should not be exposed via WSDL");
  }
}