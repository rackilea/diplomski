wbb = (WebView) findViewById(R.id.webView_tobe_loaded);    
WebSettings wbset=wbb.getSettings();
wbset.setJavaScriptEnabled(true);
wbb.setWebViewClient(new MyWebViewClient());
String url="http://www.google.com";
wbb.loadUrl(url);