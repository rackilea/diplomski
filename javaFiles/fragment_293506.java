public class Tos extends Activity {

     //UI ELEMENTS
    private Button button;
    private WebView TermswebView;

    public void onCreate(Bundle savedInstanceState) {
    final Context context = this;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tos);
    TermswebView = (WebView) findViewById(R.id.webView);
    TermswebView.loadUrl("http://www.barglance.com/assets/tos/tos.php");


    button = (Button) findViewById(R.id.buttonUrl);

    button.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View arg0) {
        Intent intent = new Intent(context, Mapp.class);
        startActivity(intent);
      }

    });

}