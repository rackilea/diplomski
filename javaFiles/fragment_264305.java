setContentView(R.layout.main);
        WebView webview = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webSettings.setBuiltInZoomControls(true);

        webview.requestFocusFromTouch();

        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient());    

     webview.loadUrl("file:///android_asset/test.html");