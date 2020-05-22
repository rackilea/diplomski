public class MainActivity extends AppCompatActivity {
    private Button b;
    private EditText cells;
    private TextView ans;
    String s = "Answer";
    double c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        cells = (EditText) findViewById(R.id.editText_cells);
        ans = (TextView) findViewById(R.id.textView3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    c = Double.parseDouble(cels.getText().toString());
                    s = Double.toString(c+((c*3)/100));
                    char ch[] = s.toCharArray();
                    ans.setText(ch, 0, ch.length)
            }
        });
   }