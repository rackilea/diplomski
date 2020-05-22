public class ClientPasswordCallback implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException, 
            UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        if ("login".equals(pc.getIdentifier())) {
            pc.setPassword("thepassword");
        } // else {...} - can add more users, access DB, etc.
    }
}