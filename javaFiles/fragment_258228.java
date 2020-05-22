public class MainActivity extends Activity {

    Button button ;
    ProgressBar bar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar)findViewById(R.id.pbar);
        button = (Button)findViewById(R.id.btn);
.....
}}