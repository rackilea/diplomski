dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.getWindow().requestFeature(Window.FEATURE_PROGRESS);
    dialog.setContentView(R.layout.webview_content);





    WebView webView = (WebView) dialog
            .findViewById(R.id.webView);
    webView.getSettings().setJavaScriptEnabled(true);
             webView.loadUrl("YOUR URL");

       dialog.show();