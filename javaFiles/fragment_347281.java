WebView webView = new WebView(context_);

webView.getSettings().setJavaScriptEnabled(true);
webView.getSettings().setPluginsEnabled(true);
webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+LINK_TO_PDF);

setContentView(webView);