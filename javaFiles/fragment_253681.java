Intent intent = getIntent();
if (intent.getExtras() != null) {
    Message resultMsg = intent.getExtras().getParcelable("MESSAGE");
    WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
    transport.setWebView(mWebView);
    resultMsg.sendToTarget();