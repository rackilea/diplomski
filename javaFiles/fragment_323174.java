private void createAuthentication(String localProxyHost, String localProxyPort, 
    String localProxyUser, String localProxyPassword, String domain, 
    String username, String password) {

    if (!prepared) {
        System.setProperty("java.net.useSystemProxies", "true");

        System.setProperty("http.auth.ntlm.domain", domain);
        System.setProperty("proxyHost", localProxyHost);
        System.setProperty("proxyPort", localProxyPort);
        System.setProperty("proxyUser", localProxyUser);
        System.setProperty("proxyPassword", localProxyPassword);

        prepared = true;
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });
    }
}