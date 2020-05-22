public class MainActivity extends Activity{

public static TextView textViewToChange;

 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textViewToChange = (TextView) findViewById(R.id.textViewToChange);

    }
}