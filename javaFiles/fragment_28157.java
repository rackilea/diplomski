public class MainActivity extends Activity

{

    LinearLayout ll;
    TextView tv;

    FrameLayout ff2, ff1, ff3, ff4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ff1 = (FrameLayout) findViewById(R.id.lay1);
        ff2 = (FrameLayout) findViewById(R.id.lay2);
        ff3 = (FrameLayout) findViewById(R.id.lay3);
        ff4 = (FrameLayout) findViewById(R.id.lay4);
        ff3.setVisibility(View.GONE);
        ff4.setVisibility(View.GONE);

        tv = (TextView) findViewById(R.id.tvText);
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ff1.setVisibility(View.GONE);
                ff2.setVisibility(View.GONE);
                ff3.setVisibility(View.VISIBLE);
                ff4.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "layout change",
                        Toast.LENGTH_LONG).show();

            }
        });

    }

}