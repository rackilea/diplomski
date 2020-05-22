@JavascriptInterface
    public void reloadSite(){
        Toast.makeText(mContext, getString(R.string.reloadingWebApp), Toast.LENGTH_LONG).show();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mWebView = (WebView) findViewById(R.id.activity_main_webview);
                mWebView.loadUrl(getString(R.string.web_app_url));
            }
        });
    }