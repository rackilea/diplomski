WebDriver driver = new HtmlUnitDriver(true) {
    @Override
    protected WebClient modifyWebClient(WebClient client) {
        client.getOptions().setThrowExceptionOnScriptError(false);
        return client;
    }
};