public class MainActivity extends ActionBarActivity  {

MediaPlayer one;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = MediaPlayer.create(this, R.raw.one);