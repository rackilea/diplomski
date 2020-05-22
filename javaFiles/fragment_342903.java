public class IncomingLdapConnection 
implements ServerConnection<Integer> {

    public void handleBind(Integer ctx, int version, BindRequest request,
        ResultHandler<? super BindResult> resultHandler,
        IntermediateResponseHandler intermediateResponseHandler)
throws UnsupportedOperationException {
    if (request.getAuthenticationType() != -128) {
        logger.warn("LDAP BIND: unsupported authentication type: " + request.getAuthenticationType());
        resultHandler.handleResult(Responses.newBindResult(ResultCode.AUTH_METHOD_NOT_SUPPORTED));
        return;
    }

    String bindName = request.getName();
    if (bindName.length() > 0) {
        if (request instanceof GenericBindRequest) {
            GenericBindRequest bindRequest = (GenericBindRequest)request;

            String userName = parseUidDn(bindName);
            if (userName == null) {
                // manche LDAP-Clients senden keine DN, sondern direkt den Namen
                userName = bindName;
            }

            String password = bindRequest.getAuthenticationValue().toString();

            logger.debug("LDAP BIND: non-anonymous bind, user = " + userName);
            anonymous = false;
        } else {
            logger.warn("LDAP BIND: non-anonymous bind, but unsupported request");
            resultHandler.handleResult(Responses.newBindResult(ResultCode.AUTH_METHOD_NOT_SUPPORTED));
            return;
        }
    } else {
        logger.debug("LDAP BIND: anonymous bind");
        anonymous = true;
    }

    boolean success = anonymous;
    if (!anonymous) {
        // authenticate user, set "success"
    }

    if (success)
        resultHandler.handleResult(Responses.newBindResult(ResultCode.SUCCESS));
    else
        resultHandler.handleResult(Responses.newBindResult(ResultCode.INVALID_CREDENTIALS));

    authenticated = success;
}