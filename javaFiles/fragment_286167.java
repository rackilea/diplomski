WebDriver driver = new HtmlUnitDriver() {
    protected WebClient modifyWebClient(WebClient client) {
        // This class ships with HtmlUnit itself
        DefaultCredentialsProvider creds = new DefaultCredentialsProvider();

        // Set some example credentials
        creds.addCredentials("username", "password");

        // And now add the provider to the webClient instance
        client.setCredentialsProvider(creds);

        return client;
    }
};