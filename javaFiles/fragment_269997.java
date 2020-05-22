public class RegisterActivity extends AppCompatActivity
{
    private EditText edtname, edtnumber;
    private Spinner spblood;
    private Button btnregister, btnlist;
    private SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spblood.setAdapter(adapter);

        sqLiteHelper = SQLiteHelper.getInstance(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                        sqLiteHelper.insertData(
                        edtname.getText().toString().trim(),
                        edtnumber.getText().toString().trim(),
                        spblood.getSelectedItem().toString()
                    );
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, DonorList.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        edtname = findViewById(R.id.name_input);
        edtnumber = findViewById(R.id.numberinput);
        spblood = findViewById(R.id.blood_selector);
        btnregister = findViewById(R.id.register_button);
        btnlist = findViewById(R.id.list_button);
    }
}