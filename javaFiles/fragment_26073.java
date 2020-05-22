WebViewClient yourWebClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            wb.loadUrl("javascript:HtmlViewer.showHTML" +
                    "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }
    };
    wb = (WebView) findViewById(R.id.webview);
    wb.getSettings().setJavaScriptEnabled(true);
    wb.getSettings().setSupportZoom(true);
    wb.getSettings().setBuiltInZoomControls(true);
    wb.setWebViewClient(yourWebClient);
    wb.loadUrl("http://pqrs.abcde.com/facebook");
    wb.addJavascriptInterface(new MyJavaScriptInterface(this), "HtmlViewer");