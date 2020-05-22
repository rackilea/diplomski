@WebService
public class MyWebService 
{
    @Resource
    WebServiceContext wsContext;

    @WebMethod
    public String ProcessQuery(@WebParam(name="query") String q)
    {
        MessageContext messageContext = wsContext.getMessageContext();
        HttpServletRequest request = (HttpServletRequest) messageContext.get(SOAPMessageContext.SERVLET_REQUEST);

        // now you can get anything you want from the request
    }

}