webview.setWebViewClient(new MyWebViewClient ());

private class MyWebViewClient extends WebViewClient {
    @Override
    public void onReceivedHttpAuthRequest(WebView view,
            HttpAuthHandler handler, String host, String realm) {
        handler.proceed("me@test.com", "mypassword");
    }
}