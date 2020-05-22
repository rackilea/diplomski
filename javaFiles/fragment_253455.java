public HttpRequestor getProxy(){

    if("true".equals(config.getProperty("proxy","false"))){
        String ip = "proxy.myproxy.com";
        int port = 80;

        final String authUser = "username";
        final String authPassword = "password";

        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(authUser, authPassword.toCharArray());
            }
        });

        Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port));


        HttpRequestor req = new StandardHttpRequestor(proxy);
        return req;
    }
    return null;
}