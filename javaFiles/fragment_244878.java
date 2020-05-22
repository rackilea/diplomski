Tab tab = new Tab(...);
// ...
WebView webView = new WebView(...);
// ... layout, etc tab content, etc...
tab.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
    if (isNowSelected) {
        currentWebView = webView ;
    }
});