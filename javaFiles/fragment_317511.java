public class MainActivity extends AppCompatActivity {

    List<String> pn, txt;
    Spinner sp1, sp2;
    Button b, b1, b2, b3;
    EditText et, et1;

    ArrayAdapter<String> adp1, adp2; // Added

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSpinners();

        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        et = (EditText) findViewById(R.id.editText);
        et1 = (EditText) findViewById(R.id.editText1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adp1.add(et.getText().toString());  // Changed
                et.setText("");
            }
        });

       b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adp2.add(et1.getText().toString());
                et1.setText("");
            }
        });
    }

    public void setupSpinners() {

        sp1 = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinner1);
        pn = new ArrayList<String>();
        txt = new ArrayList<String>();
        txt.add("Sorry Boss I'cant go today i'm sick");
        pn.add("123456789");

        adp1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, pn);
        adp2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, txt);

        sp1.setAdapter(adp1);
        sp1.setSelection((pn.size() - 1));
        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                sp2.setSelection(arg2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        sp2.setAdapter(adp2);

    }
}