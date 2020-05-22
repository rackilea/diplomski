@WebService(serviceName="MyServices")
public class MyWebServiceClass extends SpringBeanAutowiringSupport {
    @WebMethod
    public List<String> myMethodExposed(String username) {
      List<String> toret = new ArrayList<String>();
      toret.add("Hello world");
      toret.add("Life id beautiful");
      return toret;
    }
}