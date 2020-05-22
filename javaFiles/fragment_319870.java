public class MainActivity extends Activity {


   private  EditText ETtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        ETtitle = (EditText) findViewById(R.id.ETtitle);
        EditText ETcontent = (EditText) findViewById(R.id.ETcontent);
        button.setOnClickListener(new buttonOnClickListener());

        }
    public class buttonOnClickListener implements View.OnClickListener {

        public void onClick(View v) {
            String ETtitleStr = ETtitle.getText().toString();
        }

    }
}