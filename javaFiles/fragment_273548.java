@WebService(name = "dataService", targetNamespace = "http://example.com/vap/webservice/dataservice/definition")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface DataSEI {

    @WebMethod(action = "createAction", operationName = "create")
    DataTransferObjectStatusContainer create(
            @WebParam(name = "objects", targetNamespace = "http://example.com/vap/webservice/dataservice/definition")
            DataTranferObjectContainer pObjectsContainer,
            @WebParam(name = "atomic", targetNamespace = "http://example.com/vap/webservice/dataservice/definition")
            boolean pAsAtomicOperation) throws Fault;
}