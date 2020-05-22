public class Editbills extends AppCompatActivity {
    Button button;
    private static final String Tag = "assignments";
    DBAdapter db = new DBAdapter(this);
    private String selectedName;
    private long selectedID;
    DBAdapter dbAdapter;
    private EditText editText,editText2,editText3;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editbills);
        context = this;
        dbAdapter = new DBAdapter(this); //<<<< ADDED
        button=(Button)findViewById(R.id.button);
        editText =(EditText)findViewById(R.id.edittext);
        editText2=(EditText)findViewById(R.id.edittext2);
        editText3 =(EditText)findViewById(R.id.edittext3);
        //get the intent extra from the ListDataActivity
        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getLongExtra(MainActivity.ID_INTENTEXTRA,-1L); //NOTE: -1 is just the default value
        populateDisplay(selectedID);

        //now get the name we passed as an extra
        //selectedName = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        //editText.setText(selectedName); <<<< commented out
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                Log.d("test", "adding");
                db.open();
                long id = db.insertRecord(editText.getText().toString(), editText2.getText().toString(), editText3.getText().toString());
                db.close();
                Toast.makeText(Editbills.this," Added", Toast.LENGTH_LONG).show();
                */
                /*
                * <<<< Not the way as it ends/closes the existing activity
                Intent q = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(q);
                */
                String toast = "Updated.";
                if (dbAdapter.updateRecord(selectedID,
                        editText.getText().toString(),
                        editText2.getText().toString(),
                        editText3.getText().toString())) {
                } else {
                    toast = "Not Updated.";
                }
                Toast.makeText(context,toast,Toast.LENGTH_LONG).show();
                finish(); //<<<< ends/closes this activity and returns to calling activity
            }
        });
    }

    private void populateDisplay(long id) {
        Cursor csr = dbAdapter.getRecordById(id);
        if (csr.moveToFirst()) {
            editText.setText(csr.getString(csr.getColumnIndex(DBAdapter.KEY_NAME)));
            editText2.setText(csr.getString(csr.getColumnIndex(DBAdapter.KEY_AMOUNT)));
            editText3.setText(csr.getString(csr.getColumnIndex(DBAdapter.KEY_DUEDATE)));
        }
        csr.close();
    }
}