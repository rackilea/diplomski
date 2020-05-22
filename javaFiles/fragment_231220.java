public class WebViewActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    private WebSettings webSettings;
    private View view3;
    private ProgressBar loadingBar;
    private SwipeRefreshLayout refreshLayout;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        view3 = findViewById(R.id.view3);
        loadingBar = findViewById(R.id.loadingBar);
        refreshLayout = findViewById(R.id.swipeContainer);
        webview = findViewById(R.id.webview);

        webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSaveFormData(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        loadWebView();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                loadWebView();
            }
        });

    }
    private void loadWebView(){
        String urlLink="https://stackoverflow.com/questions/57478675/android-webview-refreshing-when-scrolling-down";
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                refreshLayout.setRefreshing(false);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webview.setWebChromeClient(new WebChromeClient());
        webview.clearCache(true);
        webview.loadUrl(urlLink);
    }
}