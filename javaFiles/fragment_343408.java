public class TestActivity extends Activity {  
    Button btnDisplay;
    ImageButton btnAdd;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.linearLayoutForm);
        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnAdd.setOnClickListener(addListener);
        //TODO: btnDisplay
    }

    /*
     * We define our OnClickListener that will act when we click on the btn.
     */
    View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final LinearLayout newView = (LinearLayout) getLayoutInflater().inflate(R.layout.rowdetail, null);

            newView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            ImageButton btnRemove = (ImageButton) newView.findViewById(R.id.btnRemove);
            btnRemove.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    container.removeView(newView);
                }
            });

            container.addView(newView);

            //Now we load your data into your spinner
            Spinner s = newView.findViewById(R.id.spinner1);
            try {
                loadSpinnerData(s);
            } catch (IOException e) {
                //TODO: catch exception
                e.printStackTrace();
            }

        }
    };

    /*
     * This function is supposed to load the data into the given spinner.
     * It would be better to load the data an other way, i.e.: using ASyncTask
     */
    private void loadSpinnerData(Spinner s) throws IOException {

        // database handler
        DBHelper db = new DBHelper(getApplicationContext());

        // Spinner Drop down elements
        List<String> products = db.getAllProducts();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, products);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s.setAdapter(dataAdapter);

    }
}