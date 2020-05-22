@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dsaif);
    runDialog(5);
    WebView engine = (WebView) findViewById(R.id.web_engine);
    engine.loadUrl("http://android.dsaif.tk/store/");
    engine.setWebViewClient( new HelloWebViewClient() );
} 



  private class HelloWebViewClient extends WebViewClient {

      @Override
      public boolean shouldOverrideUrlLoading( WebView view, String url ) {                 

         return false;
      }
  }