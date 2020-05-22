public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(v);
        NonActivityClass nac = new NonActivityClass(MainActivity.this, v);
        nac.test();
    }
}