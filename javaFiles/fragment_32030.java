final String url = "https://noor.moe.gov.sa/Noor/login.aspx";
WebView mWebView = (WebView) v.findViewById(R.id.webView);
mWebView.setInitialScale(1);
mWebView.getSettings().setUseWideViewPort(true);

mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!url.equals("about:blank")) {
                    view.loadUrl(url);
                }
                return false;
            }
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

mWebView.loadUrl(url);