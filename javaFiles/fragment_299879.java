public class portscan extends AppCompatActivity {
    EditText Portaa;
    EditText Portbb;
    EditText Iptot;
    TextView rez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portscan);
     Portaa  = (EditText)findViewById(R.id.editText3);
    Portbb = (EditText)findViewById(R.id.editText4);
    Iptot = (EditText)findViewById(R.id.editText5);
    rez = (TextView)findViewById(R.id.textView18);

    }...