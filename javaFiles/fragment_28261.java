public class SampleClass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_class);

        Intent intent = getIntent(); 
        Bundle extras = intent.getExtras(); 
        String jsonData = extras.getString( "com.parse.Data" );

        Log.i("Data Received:", jsonData);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sample_class, menu);
        return true;
    }