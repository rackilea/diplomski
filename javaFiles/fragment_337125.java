Browser.setWebViewClient(new WebViewClient()       
        {
     @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) 
    {
        return false;
    }
});