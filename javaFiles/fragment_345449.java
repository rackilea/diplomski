public class MainActivity extends Activity {
    Button buttonOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOff = (Button)findViewById(R.id.button1);
        buttonOff.setOnClickListener(new CustomOnClickListener(this));
    }