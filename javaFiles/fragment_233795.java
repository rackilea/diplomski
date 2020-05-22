public class MainActivity extends ActionBarActivity {

    ArrayList<String> arrayNames = new ArrayList<String>();
    ListView listNames;
    TextView namesText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Creating and Printing Lists
        listNames = (ListView) findViewById(R.id.listNamesId);
        namesText = (TextView) findViewById(R.id.namesTexter);
        final ArrayAdapter<String> adapterNames = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, arrayNames);
        listNames.setAdapter(adapterNames);

        Button buttonPlus = (Button)findViewById(R.id.buttonPlus);

        buttonPlus.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        arrayNames.add(0, namesText.getText().toString());
                        adapterNames.notifyDataSetChanged();
                        namesText.setText("");

                    }
                }
        );


    }