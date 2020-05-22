public class WebViewActivity extends Activity  {

   private WebView wv1;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      wv1=(WebView)findViewById(R.id.webView);


      wv1.getSettings().setLoadsImagesAutomatically(true);
      wv1.getSettings().setJavaScriptEnabled(true);
      wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
      wv1.loadUrl(your_url);

   }
}