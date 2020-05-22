super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_monster);


    WebView webView = (WebView) findViewById(R.id.webView);



    String url = getIntent().getExtras().getString("url");


    webView.setWebViewClient(new WebViewClient());
    webView.loadUrl("url");