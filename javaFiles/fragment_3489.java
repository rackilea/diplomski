@WebService
public class MyService {

  @Resource
  WebServiceContext wsContext; 

  /**
   * Web service operation
   */ 
  @WebMethod 
  public String myMethod() { 

    MessageContext mc = wsContext.getMessageContext();
    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
    System.out.println("Client IP = " + req.getRemoteAddr()); 

  }

}