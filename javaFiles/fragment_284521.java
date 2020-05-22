public class Test3Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String url ="file:///android_asset/qualibus.swf";

        WebView wv=(WebView) findViewById(R.id.webView1);
        wv.getSettings().setPluginsEnabled(true);
        wv.loadUrl(url);
    }
}