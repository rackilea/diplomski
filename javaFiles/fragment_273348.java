Spinner spGender;
    double bmr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("male");
        spinnerArray.add("female");
        spGender = (Spinner) findViewById(R.id.spinnerGender);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArray);
        spGender.setAdapter(arrayAdapter);
        final TextView tvGender = (TextView) findViewById(R.id.tvGenderTemp);
        spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                tvGender.setText(item);
                //BMR FORMULA PART II
                double userWeight = 10;
                double userHeight = 20;
                double userAge = 35;
                if (spGender.getSelectedItem().equals("female"))
                {
                    bmr = (655 + (13.7 * userWeight) + (5.0 * userHeight) - (6.8 * userAge));
                } else {
                    bmr = 66 + (13.7 * userWeight) + (1.8 * userHeight) - (4.7 * userAge);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Please select a gender!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
        Button btnUPSave = (Button) findViewById(R.id.btnUserProfileSave);
        btnUPSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Saved!",
                        Toast.LENGTH_LONG).show();

                Intent in2 = new Intent(getApplicationContext(), Main2Activity.class);
                in2.putExtra("mBMR", bmr);
                startActivity(in2);
            }
        });

    }