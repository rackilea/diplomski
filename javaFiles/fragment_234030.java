wv = (WebView) findViewById(R.id.webview);
wv.getSettings().setJavaScriptEnabled(true);
wv.loadUrl("http://m.homedepot.com");
wv.setWebViewClient(new WebViewClient()
    {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return(true);
    }
    }
);