public void doAuthenticationRedirect (HttpServletResponse response, final HttpSession currentSessiond) throws Exception {  

    /** Generate your authnrequest **/
    AuthnRequest authnRequest = generateAuthnRequest();  

    /** Create an adapter from tomcat response servlet **/
    HttpServletResponseAdapter responseAdapter = new HttpServletResponseAdapter(response, true); 

    /** 302 status code **/
    responseAdapter.setStatusCode(HttpServletResponse.SC_MOVED_TEMPORARILY);

    /** Build blank context **/
    SAMLMessageContext<?, AuthnRequest, ?> context =  SAMLUtility.makeSamlMessageContext();

    /** Set entity end point**/
    context.setPeerEntityEndpoint(endpointObject);  

    context.setOutboundSAMLMessage(authnRequest);  

   /** Sign this request **/
    context.setOutboundSAMLMessageSigningCredential(getSigningCredential());  
    context.setOutboundMessageTransport(responseAdapter);
     /** Run encoder **/
    try {  
        runEncoder(new HTTPRedirectDeflateEncoder(), context);
    } catch (Throwable t) {  
        Log.error("Error endcoding AuthnRequest: ",t);
    }  
}  


 /** 
  * Encode our Context and send it
  * 
  * @param encoder
  * @param context
  * @throws IOException
  * @throws MessageEncodingException
  */
  private void runEncoder(MessageEncoder encoder, MessageContext context)      throws IOException, MessageEncodingException {
      encoder.encode(context);
  }