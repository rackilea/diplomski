public class CustomProxyAuthenticator implements Authenticator {

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        String username = Configurator.getInstance().getProxyUser();
        String password = Configurator.getInstance().getProxyPassword();

        String credential = Credentials.basic(username, password);
        return response.request().newBuilder()
                .header("Proxy-Authorization", credential)
                .build();
    }
}