private WebView webView;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    webView = findViewById(R.id.external_url_content);
    webView.getSettings().setJavaScriptEnabled(true);
}

@Override
protected void onResume() {
    super.onResume();
    Uri url = getIntent().getData();
    if (url != null) {
        Log.d("TAG", "URL Foud");
        Log.d("TAG", "Url is :" + url);
        webView.loadUrl(url.toString());
    }
}