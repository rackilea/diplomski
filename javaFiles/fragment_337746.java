// Registering the JS interface
mWebView.addJavascriptInterface(new JSInterface(), "JSInterface");
// Waiting for the page to be fully loaded, and injecting the JS code
mWebView.setWebViewClient(new WebViewClient() {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        view.loadUrl(INJECTED_CODE);
    }
});
// Load your custom url
mWebView.loadUrl(YOUR_ACTUAL_URL);

/**
 * Interface between Java and Javascript.
 */
public class JSInterface {

    @JavascriptInterface
    public void showToast(String toast) {
        Log.d("debug", "I got : " + toast);
    }
}