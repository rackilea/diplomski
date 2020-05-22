wv.setWebViewClient(new WebViewClient() {
    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
    }
 });