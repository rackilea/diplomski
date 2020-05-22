private WebView webView;
  public onViewCreated(....) {
       webView = view.findViewBy(R.id.webview);
       ....
  }

  public WebView getWebView() {
       return webView;
  }