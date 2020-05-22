public class MyWebViewClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading (WebView view, String url) {
        if (Uri.parse(url).getHost().equals("http://Your_website_url")) {
             // This is my web site, so do not override; let my WebView load the page
             return false;
        }

        // reject anything other
        return true;
    }
}


mWebview.setWebViewClient(new MyWebViewClient());  //set the webviewClient