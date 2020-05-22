public class Scroll extends AppCompatActivity {
    TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        btn = (TextView) findViewById(R.id.text)
        //^^^^
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        btn.setText(""+intValue);                
      }
}