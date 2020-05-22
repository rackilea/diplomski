private String extractXACMLRequest(String decisionQuery) throws Exception {
    RequestType xacmlRequest = null;
    doBootstrap();
    String queryString = null;
    XACMLAuthzDecisionQueryType xacmlAuthzDecisionQuery;
    try {
        xacmlAuthzDecisionQuery = (XACMLAuthzDecisionQueryType) unmarshall(decisionQuery);
        //Access the XACML request only if Issuer and the Signature are valid.
        if (validateIssuer(xacmlAuthzDecisionQuery.getIssuer())) {
                if (validateSignature(xacmlAuthzDecisionQuery.getSignature())) {
                    xacmlRequest = xacmlAuthzDecisionQuery.getRequest();
                } else {
                    log.debug("The submitted signature is not valid!");
                }
        } else {
            log.debug("The submitted issuer is not valid!");
        }

        if (xacmlRequest != null) {
            queryString = marshall(xacmlRequest);
            queryString = queryString.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").replace("\n", "");
        }
        return queryString;
    } catch (Exception e) {
        log.error("Error unmarshalling the XACMLAuthzDecisionQuery.", e);
        throw new Exception("Error unmarshalling the XACMLAuthzDecisionQuery.", e);
    }

}