WebView view ; //Global    

  @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        view = (WebView) this.findViewById(R.id.webView);
                view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new ZeroBrowser());
        view.loadUrl("http://www.google.com");
    }