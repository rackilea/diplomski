public class SecondActivity extends Activity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        tv = (TextView) findViewById(R.id.textView1);

        Bundle b = getIntent().getExtras();
        String pos = b.getString("index");
        tv.setText("Position = " + pos);
    }

}