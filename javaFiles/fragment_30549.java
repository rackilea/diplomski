Handler webViewInflateHandler = new Handler();
    webViewInflateHandler.postDelayed(new Runnable() {
        @Override
        public void run() {
            if (!webViewInflated) {
                webView = (WebView) webViewStub.inflate();
                webViewInflated = true;
            }
        }
    }, 50);