public class MainActivity extends AppCompatActivity {


    private List<String> words;

    private List<String> defn;

    private String d="";
    ListView list;
    ArrayAdapter<String> adap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        words = new ArrayList<>();
        words.add("Ankit Rath");
        words.add("Mediocre");
        words.add("Idiot");
        words.add("Legend");

        defn = new ArrayList<>();
        defn.add("Creator of this App!");
        defn.add("Android Development");
        defn.add("Developer");
        defn.add("Ankit Rath");

        run();
    }

    public void run(){
        list = (ListView) findViewById(R.id.li);
        adap = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                words
        );
        list.setAdapter(adap);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String de = defn.get(i);

                Toast.makeText( getApplicationContext(),de,Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void add(View view) {
        EditText txtw = (EditText) findViewById(R.id.t1);
        String ndef = txtw.getText().toString();
        defn.add(ndef);
        EditText txtd = (EditText) findViewById(R.id.t2);
        String nword = txtd.getText().toString();
        words.add(nword);
        adap.notifyDataSetChanged();
    }

    public void reset1(View view) {
        EditText t1 = (EditText) findViewById(R.id.t1);
        t1.setText("");

    }
    public void reset2(View view) {
        EditText t2 = (EditText) findViewById(R.id.t2);
        t2.setText("");

    }
}