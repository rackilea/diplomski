public class MainActivity extends AppCompatActivity {

    Database database;
    Spinner currency_code_selector;
    SimpleCursorAdapter mSCA;
    Cursor csr;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currency_code_selector = this.findViewById(R.id.currrency_code_selector);

        database = new Database(this);
        // For testing only
        csr = database.getAllRowsFromCurrencyTable();
        DatabaseUtils.dumpCursor(csr);
        manageCurrencyCodeSpinner();
    }

    private void manageCurrencyCodeSpinner() {
        csr = database.getAllRowsFromCurrencyTable();
        if (mSCA == null) {
            mSCA = new SimpleCursorAdapter(
                    this, // The context
                    android.R.layout.simple_dropdown_item_1line, // The layout (stock layout used)
                    csr, // The Cursor for the Spinner
                    new String[]{Database.CURRENCY_CODE_COLUMN}, // The columns holding the data
                    new int[]{android.R.id.text1}, // The View into which the data is placed
                    0 // 0 is fine
            );
            currency_code_selector.setAdapter(mSCA); // Tie the adapter to the Spinner
            // Setup selection handling
            currency_code_selector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (view == null) return;
                    Toast.makeText(view.getContext(),
                            "You have just selected the currency code " +
                                    csr.getString(csr.getColumnIndex(Database.CURRENCY_CODE_COLUMN)) +
                                    ". The ID is " + String.valueOf(id),
                            Toast.LENGTH_SHORT ).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else {
            mSCA.swapCursor(csr); // if spinner already setup refresh the contents
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        csr.close(); //<<<<<<<<<< close the cursor when done with it
    }

    @Override
    protected void onResume() {
        super.onResume();
        manageCurrencyCodeSpinner(); // refresh the Spinner as data may have changed
    }
}