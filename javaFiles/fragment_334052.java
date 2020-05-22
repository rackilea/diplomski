public class MyWebClient extends WebViewClient {

@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    view.loadUrl(url);
    return true;
}

@Override
public void onPageFinished(WebView view, String url) {
    view.loadUrl("javascript:your javascript");
}
}
.........
final MyWebClient myWebViewClient = new MyWebClient();
mWebView.setWebViewClient(myWebViewClient);