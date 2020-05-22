public class Example extends Activity {
    Button start;
    Button restart;
    TextView t;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        start = (Button) findViewById(R.id.start);
        restart = (Button) findViewById(R.id.restart);
       check = (TextView) findViewById(R.id.check);
    }
}