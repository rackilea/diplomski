WebView browser = (WebView) findViewById(webview);
    browser.getSettings().setJavaScriptEnabled(true);
    browser.setWebChromeClient(new WebChromeClient());
    browser.loadUrl("file:///android_asset/www/index.html");
    browser.setWebViewClient(new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
    });