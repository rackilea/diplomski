@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
  swipeRefreshLayout.setOnRefreshListener(this);

  WebView myWebView = (WebView) findViewById(R.id.webview);
    WebSettings webSettings = myWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    myWebView.setWebViewClient(new MyWebViewClient());
    myWebView.loadUrl("http://www.facebook.com");
  }


private class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        webView.setWebChromeClient(new MyWebChromeClient());
        if(Uri.parse(url).getHost().length() == 0) {
            return false;
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
         swipeRefreshLayout.setRefreshing(false);
        super.onPageFinished(view, url);
    }
}

@Override
public void onRefresh() {
      myWebView.loadUrl("http://www.facebook.com");
      swipeRefreshLayout.setRefreshing(true);
}