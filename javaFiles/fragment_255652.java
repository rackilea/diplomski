public class MainActivity extends AppCompatActivity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text_1);

        onEverySecond.run();
    }

    private Runnable onEverySecond=new Runnable() {
        @Override
        public void run() {
            text.setText("test");
            text.postDelayed(this, 1000);
        }
    }
}