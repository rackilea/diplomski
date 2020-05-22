webview.setWebViewClient(new WebViewClient() {
    public void onPageFinished(WebView webview, String url) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            webview.evaluateJavascript(javascript, null);
        } else {
            webview.loadUrl("javascript:(function(){" + javascript + "})()");
        }
    }
});