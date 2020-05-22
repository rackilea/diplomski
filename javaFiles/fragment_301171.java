protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mWebView = (WebView) findViewById(R.id.activity_main_webview);
    WebSettings webSettings = mWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    mWebView.addJavascriptInterface(new JavaScriptInterface(this), "Android");
    mWebView.setWebViewClient(new CustomWebViewClient(this)); 



public class CustomWebViewClient extends WebViewClient {

Activity activity;

public CustomWebViewClient (Activity activity) {
    this.activity= activity;

}

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().endsWith(PROJECT_REMOTE)) {
            return false;
        } else {
            openInAppBrowser(url);
        }
        return true;
    }
    private void openInAppBrowser(String url) {
        Intent intent = new Intent(activity, InAppBrowser.class);
        intent.putExtra("url", url);
        activity.startActivity(intent);
    }