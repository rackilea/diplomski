public class MyAuthenticationHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        final Boolean outInd = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outInd.booleanValue()) {
            try {
                UserNamePasswordPair userNamePasswordPair = getAuthorization(); // Method to retrieve credentials from somewhere

                context.put(BindingProvider.USERNAME_PROPERTY, userNamePasswordPair.getUsername());
                context.put(BindingProvider.PASSWORD_PROPERTY, userNamePasswordPair.getPassword());

            } catch (final Exception e) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        logger.error("error occurred when getting auth.");
        return false;
    }

    @Override
    public void close(MessageContext context) {
        logger.debug("closing handler for auth...");
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
}