public class MainActivity extends Activity {
 TextView textOne;
 Button pressMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOne = (TextView) findViewById(R.id.textView1);
        pressMe = (Button) findViewById(R.id.button1);