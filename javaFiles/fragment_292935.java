`
    mWebView.setWebViewClient(new WebViewClient() {
       long pageLoadStartTime;
       @Override
       public void onPageStarted(WebView view, String url) {
           pageLoadStartTime = System.currentTimeInMillies();
       }

       @Override
       public void onPageFinished(WebView view, String url) {
          long pageLoadTime = pageLoadStartTime - System.currentTimeInMillies();
      //pageLoadTime is you required data in milliseconds
       }
    });
`