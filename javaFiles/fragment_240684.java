public class TestAppActivity extends Activity {

    TextView text1;
    Button   btn1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn1 = (Button) findViewById(R.id.button1);
        text1 = (TextView) findViewById(R.id.textView1);

        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                text1.setText("yes");
            }
        });
    }
}