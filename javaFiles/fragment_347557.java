public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Bundle bundle = getIntent().getExtras();
        String key = bundle.getString("key");

        TextView textView = (TextView) findViewById(R.id.textView1); // Replace the textView1 with the id you set to your textview.
        textView.setText(key);
    }
}