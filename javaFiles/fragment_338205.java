webView.setWebViewClient(new WebViewClient() {

String urlA = "http://facebook.com";
String urlB = "http://facebook.com/friends";

public void onPageFinished(WebView view, String url) {
    if(url.equals(urlA)){
        //Do stuff if actual page url is urlA        
    }else if(url.equals(urlB)){
        //Do stuff is actual page url is urlB
    }
}
});