public class WebViewActivity extends AppCompatActivity {

private WebView webView;

@Override
protected void onCreate(Bundle savedInstanceState) {

    String url = getIntent().getStringExtra("URL");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.webview);
    webView = (WebView) findViewById(R.id.webView);
    webView.setWebViewClient(new MyBrowser());
    webView.getSettings().setLoadsImagesAutomatically(true);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    webView.loadUrl(url);
}

private class MyBrowser extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
}