myWebView.getSettings().setJavaScriptEnabled(true);
    myWebView.setWebViewClient(new MyWebViewClient());

private class MyWebViewClient extends WebViewClient {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
         view.loadUrl(url);
         return true;
      }
   }