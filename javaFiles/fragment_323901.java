public class MainActivity extends Activity implements FooChangeListener {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onFooChange(String text) {
        tv.setText(text);
    }
}