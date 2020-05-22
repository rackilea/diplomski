mWebView.setWebChromeClient(new WebChromeClient(){
        @Override
        public void onConsoleMessage(String message, int lineNumber,
                String sourceID) {
            super.onConsoleMessage(message, lineNumber, sourceID);
            Log.i("VIDEO VIEW",message);
        }
 }