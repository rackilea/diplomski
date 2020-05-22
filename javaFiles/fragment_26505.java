WebView webView = (WebView)findViewById(R.id.myWebView);
WebChromeClient myWebChromeClient = new WebChromeClient(){
        @Override
        public void getVisitedHistory(ValueCallback<String[]> callback) {
// called during webview initialization, original implementation does strictly nothing 
// and defaults to the native method WebViewCore.nativeProvideVisitedHistory()
            String[] myUserHistory = getVisitedUrlsFromMyOwnDatabase(userId);
            callback.onReceiveValue(myUserHistory);
        }
    };
WebViewClient myWebViewClient = new WebViewClient(){
    @Override
public void doUpdateVisitedHistory(WebView view, String url,
        boolean isReload) {
// called whenever there is a new link being visited
        insertIfNotExistVisitedUrlIntoMyOwnDatabaseForUser(userId);
        super(view, url, isReload);
}
}
webView.setWebViewClient(myWebViewClient);
webView.setChromeClient(myWebChromeClient);
webView.getSettings().etc(whatever)...