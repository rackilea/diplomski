public class MainActivity extends Activity {
    final Activity activity = this;

    private WebView webView;

    private boolean isSplashOn = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);

        webView.setBackgroundColor(0);
        webView.setBackgroundResource(R.drawable.splash_screen);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setPluginsEnabled(true);
        webView.getSettings().setPluginState(PluginState.ON);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);

        webView.setWebViewClient(new MyWebClient());

        webView.loadUrl("http://www.google.com");
    }

    public class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            if(url.startsWith("tel:")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                startActivity(intent);

                return true;
            }

            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if(!isSplashOn) {               
                webView.setBackgroundDrawable(null);
                webView.setBackgroundColor(0);

                isSplashOn = true;
            }

            super.onPageFinished(view, url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(webView.canGoBack()) {
                webView.goBack();

                return true;
            }else {
                activity.finish();
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}