@WebMethod
@WebResult(name = "ProductEvaluation")
public ProductEvaluations myAPIRequest(@WebParam(name = "XmlProducts") final XmlProducts xmlProducts,
    @WebParam(name = "ConnectedToRealtime") final boolean connectedToRealtime,
    @WebParam(name = "Timeout") final Timeout timeout) throws ProductEvaluationFault, TimeoutFault, ProductConfigurationFault, SecurityFault {
    try {
        // some stuff here...
        return result; //result contains what I want
    } catch (SecurityException e) {
        throw new SecurityFault(e.getMessage());
    }
}