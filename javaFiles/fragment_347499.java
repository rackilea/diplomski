webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("http:\\www.atifsoftwares.blogspot.com");
        Bundle b = getIntent().getExtras();
        String url = b.getCharSequence("Url").toString();
        webView.loadUrl(url);