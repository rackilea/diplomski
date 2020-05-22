public class MainActivity extends AppCompatActivity {

    //fields
    ImageButton randomizer;
    Spinner spinner_filter;
    TextView random_recipee;
    DatabaseHelper db;
    String current_category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random_recipee = this.findViewById(R.id.recipee);
        current_category = "";

        db = new DatabaseHelper(getApplicationContext());
        //connect fields
        randomizer = (ImageButton) findViewById(R.id.logo);
        //spinner things
        spinner_filter = (Spinner) findViewById(R.id.spinner_filter);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_filter.setAdapter(adapter);
        spinner_filter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                current_category = item.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //initialize methods
        openRandomRecipe();
    }

    public void openRandomRecipe() {
        randomizer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = db.getRandomData(current_category);
                        random_recipee.setText("Nothing Found");
                        if (res.moveToFirst()) {
                            random_recipee.setText(
                                    "Recipee is " +res.getString(
                                            res.getColumnIndex(DatabaseHelper.COLUMN_RECIPES_NAME)
                                    ) +
                                            ". Category is " +
                                            res.getString(
                                                    res.getColumnIndex(DatabaseHelper.COLUMN_RECIPES_CATEGORY)
                                            )
                            );
                        }
                        res.close(); //<<<<<<<<<< should always close cursor when done with it.
                        return;
                        //add recipe link (columnIndex 1) to buffer sequence
                        //StringBuffer buffer = new StringBuffer();
                        /*
                        while (res.moveToNext()) {
                            buffer.append(res.getString(1));
                        }
                        */
                        //convert buffer to st
                        //String sr = buffer.toString();
                        //open link in browser
                        //startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(sr)));

                    }
                }
        );
    }
}