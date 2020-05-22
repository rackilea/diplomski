WebView browser = (WebView) findViewById(R.id.webview);

        String url = "http://www.google.com";
        browser .setWebViewClient(new MyBrowser());
        browser .getSettings().setLoadsImagesAutomatically(true);
        browser .getSettings().setJavaScriptEnabled(true);
        browser .setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser .loadUrl(url);

 private class MyBrowser extends WebViewClient {
  @Override
  public boolean shouldOverrideUrlLoading(WebView view, String url) {
     view.loadUrl(url);
     return true;
  }
 }