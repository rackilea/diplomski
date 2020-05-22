private EditText name;
private EditText dob;
private EditText pass;
private RadioGroup gender;
private Button update;
private Button search;
private Button delete;
private RadioButton male;
private RadioButton female;
DBHelper db;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_profile);

    name = (EditText) findViewById(R.id.username);
    dob = (EditText) findViewById(R.id.dob);
    pass = (EditText) findViewById(R.id.pass);
    gender = (RadioGroup) findViewById(R.id.gender);
    search = (Button) findViewById(R.id.search);
    update = (Button) findViewById(R.id.edit);
    delete = (Button) findViewById(R.id.delete);
    male= (RadioButton) findViewById(R.id.Male);
    female =(RadioButton) findViewById(R.id.Female);


    final String radiobuttenid = String.valueOf(gender.getCheckedRadioButtonId());


    db = new DBHelper(this);

    search.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Cursor cs = db.readAllInfo(name.getText().toString());
            int i =cs.getCount();
            if(i<=0){
                Toast.makeText(EditProfile.this,"User not Found !",Toast.LENGTH_LONG).show();
            }
            while (cs.moveToNext()) {
                dob.setText(cs.getString(2));
                if(cs.getString(3).toString().matches("Male")){
                    male.setChecked(true);
                }else{
                    female.setChecked(true);
                }
                pass.setText(cs.getString(4));
            }
        }
    });


    update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (db.updateInfo(name.getText().toString(), dob.getText().toString(), radiobuttenid, pass.getText().toString())) {
                Toast.makeText(EditProfile.this, "Data Updated", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(EditProfile.this, "Data Not Updated", Toast.LENGTH_LONG).show();
            }
        }
    });

    delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (db.deleteInfo(name.getText().toString())) {
                Toast.makeText(EditProfile.this, "Data Deleted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(EditProfile.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
            }
        }
    });

    db.close();
}