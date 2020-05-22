String sWebsite;
    Bundle bundle = getIntent().getExtras();
    if (bundle != null)
    {
        sWebsite = bundle.getString("websiteURL");
    }
    else if (bundle== null)
    {
        System.out.println("Null");
    }

    WebView webView = (WebView) findViewById(R.id.webview1);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.loadUrl(sWebsite);
    webView.setWebViewClient(new WebViewClient()
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            return false;
        }
    });