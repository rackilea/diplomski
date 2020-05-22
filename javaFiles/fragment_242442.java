@WebService(name = "myname", serviceName = "myname", targetNamespace = "com.test")
@SOAPBinding(parameterStyle=ParameterStyle.BARE)
publi class MySoapServlet {
    @WebMethod(operationName = "MyNameOperation")   
    @WebResult(name = "MyNameResult")
    public MyResponse getRsp(@WebParam(name = "MyNameReq") MyNameReq req) {
        //return...
    }
}