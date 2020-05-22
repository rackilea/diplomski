@Override
public SAMLMessageContext getLocalAndPeerEntity(HttpServletRequest request, HttpServletResponse response) throws MetadataProviderException {

        SAMLMessageContext context = new SAMLMessageContext();
        populateGenericContext(request, response, context);
        //changed to send URL instead of URI
        populateLocalEntityId(context, request.getRequestURL().toString());
        populateLocalContext(context);
        populatePeerEntityId(context);
        populatePeerContext(context);
        return context;

}

@Override
public SAMLMessageContext getLocalEntity(HttpServletRequest request, HttpServletResponse response) throws MetadataProviderException {

        SAMLMessageContext context = new SAMLMessageContext();
        populateGenericContext(request, response, context);
        populateLocalEntityId(context, request.getRequestURL().toString());
        populateLocalContext(context);
        return context;

}

    @Override
    protected void populateLocalEntityId(SAMLMessageContext context, String requestURL) throws MetadataProviderException {

            String entityId;
            HTTPInTransport inTransport = (HTTPInTransport) context.getInboundMessageTransport();

            // Pre-configured entity Id
            entityId = (String) inTransport.getAttribute(org.springframework.security.saml.SAMLConstants.LOCAL_ENTITY_ID);
            if (entityId != null) {
                    // same code as super class

            } else { // Defaults    
               //Now setting proper entityId as required
               //in this case https://sp1.wooqer.com/sp
               if(org.apache.commons.lang.StringUtils.ordinalIndexOf(requestURL, "/", 3) != -1) {
                        context.setLocalEntityId(requestURL.substring(0, org.apache.commons.lang.StringUtils.ordinalIndexOf(requestURL, "/", 3)).concat("/sp"));
                } else {
                        context.setLocalEntityId(requestURL.concat("/sp"));
                }
                context.setLocalEntityRole(SPSSODescriptor.DEFAULT_ELEMENT_NAME);
            }
    }