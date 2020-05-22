WebDriver driver = new HtmlUnitDriver() {
        @Override
        protected WebClient getWebClient() {
            WebClient c = super.getWebClient();
            c.getCache().setMaxSize(0);
            return c;
        }
    };