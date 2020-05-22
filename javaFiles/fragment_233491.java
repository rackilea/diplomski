@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_verge);

         the_verge = (WebView) findViewById(webView1);
        // Enable Javascript
        WebSettings webSettings = the_verge.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        the_verge.setWebViewClient(new WebViewClient());
        the_verge.loadUrl("http://www.theverge.com");
    }