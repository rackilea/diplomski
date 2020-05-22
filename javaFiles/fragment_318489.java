WebView mWebView = (WebView) findViewById(R.id.webView1);
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.addJavascriptInterface(this, "webConnector");
    mWebView.addJavascriptInterface(this, "toaster");
    mWebView.loadUrl("file:///android_asset/table.html");
    }

    public String load() {
        Log.e("HelloJavascript","HelloJavascript");
        return "{\"key\":\"data\"}";
    }

    public void print(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }