public class CallerMain extends Activity {
    private AdView adView;  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caller_main);

        PublicParFun.setAdIfNotRegistered((AdView)findViewById(R.id.adView));
    }   
}