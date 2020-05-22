public class MainActivity extends Activity {
        EditText editText1;
        EditText editText2;
        TextView textView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     editText1 = (EditText)findViewById(R.id.editText1);
     editText2 = (EditText)findViewById(R.id.editText2);
     textView1 = (TextView)findViewById(R.id.textView1);
    }
.........
}