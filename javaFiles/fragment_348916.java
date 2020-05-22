public void cosh2() {

        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        progressBar3.setVisibility(ProgressBar.VISIBLE);
        webView30 = (WebView) findViewById(R.id.webview30);
        webView30.setWebViewClient(new WebViewClient() {
    public void onPageFinished(WebView webview, String url) {
        progressBar3.setVisibility(ProgressBar.GONE);

    }
});
       WebSettings webSettings = webView30.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView30.loadUrl("http://rangamati.gov.bd/");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if ((keyCode==KeyEvent.KEYCODE_BACK)&&webView30.canGoBack()){
            webView30.goBack();
            return true;
        }

        return super.onKeyDown(keyCode,event);