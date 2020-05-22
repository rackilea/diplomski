protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wv = (WebView) findViewById(R.id.myWebView);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(isURLMatching(url)) {
                    openNextActivity();
                    return true;
                }
                //return super.shouldOverrideUrlLoading(view, url);
                return false;
            }
        });
    }

    protected boolean isURLMatching(String url) {
            // some logic to match the URL would be safe to have here
        return true;
    }

    protected void openNextActivity() {
        Intent intent = new Intent(this, MyNextActivity.class);
        startActivity(intent);
    }