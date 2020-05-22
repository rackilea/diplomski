public class TestActivity extends Activity {

    private TextView up;
    private TextView mid;
    private TextView down;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

     up = (TextView) findViewById(R.id.tv_up);
     mid = (TextView) findViewById(R.id.tv_mid);
     down = (TextView) findViewById(R.id.tv_down);

}