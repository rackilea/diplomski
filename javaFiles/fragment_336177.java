webView.setWebChromeClient(new WebChromeClient() {              
        @Override
        public boolean onJsAlert(WebView view, String url, String message,JsResult result) {
                    Log.d("LogTag from js call method", message);
                    str = message;
                    result.confirm();
                    return true;
           }
    });