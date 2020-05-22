mWebView = (WebView) findViewById(R.id.activity_main_webview);

mWebView.setWebViewClient(new MyAppWebViewClient(MainActivity.this) {

    @Override
    public void onPageFinished(WebView view, String url) {
        //hide loading image
        findViewById(R.id.activity_splash_logo).setVisibility(View.GONE);
        //show webview
        mWebView.setVisibility(View.VISIBLE);
    }
});

mWebView.loadUrl("http://www.example.com/");