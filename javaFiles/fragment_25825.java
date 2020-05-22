@WebService(targetNamespace = "http://test.server.callback.ws/", name = "ClassCallBackWs")
public interface Ws {
    @RequestWrapper(localName = "event", targetNamespace = "http://test.server.callback.ws/", className = "org.test.ClassParameter")
    @WebMethod
    public void event(
        @WebParam(name = "event", targetNamespace = "")
        org.test.ClassParameter event
    ) throws Exception;
}