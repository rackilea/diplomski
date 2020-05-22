server.addRequestInterceptor(new RequestInterceptor() {
    @Override
    public void process(BrowserMobHttpRequest request, Har har) {
        request.getMethod().removeHeaders("User-Agent");
        request.getMethod().addHeader("User-Agent", "Bananabot/1.0");
    }
});