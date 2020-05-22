webView.setWebChromeClient(new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100)
                progressBar.setVisibility(View.GONE);
            else {
                progressBar.setProgress(newProgress);
                progressBar.setVisibility(View.VISIBLE);
            }
        }
    });