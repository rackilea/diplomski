val webView1 = findViewById<WebView>(R.id.webview_1)
    webView1.settings.javaScriptEnabled = true
    webView1.webViewClient = WebViewClient()
    findViewById<Button>(R.id.load_webview_1).setOnClickListener {
        webView1.loadUrl("http://www.nbcsports.com/") // can be any arbitrary URL
    }