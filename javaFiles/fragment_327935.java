String [] AçoMontante = {"SAE 1020", "E-155"};
        String [] AçoBanzo = {"SAE 1020", "E-155"};
        String [] EspessuraT1 = {"0,75 mm", "0,90 mm", "0,95 mm"};
        String [] EspessuraTo = {"0,75 mm", "0,90 mm", "0,95 mm"};
        EditText campoFy1;
        EditText campoFyo;
        Button next;
        Intent intentNext;
        Bundle bundle;
        String montStr,banzoStr, f1,fo;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            campoFy1 = (EditText) findViewById(R.id.fy1);
            campoFyo = (EditText) findViewById(R.id.fyo);
            Spinner spinnerMont = (Spinner) findViewById(R.id.spinnerM);
            Spinner spinnerBanzo = (Spinner) findViewById(R.id.spinnerB);
            ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, AçoMontante);
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, AçoBanzo);
            spinnerMont.setAdapter(arrayAdapter1);
            spinnerBanzo.setAdapter(arrayAdapter2);
            spinnerMont.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                    montStr = (String) parent.getItemAtPosition(i);
                    if(montStr == "SAE 1020"){
                        f1 = "250.0";
                    }
                    else if (montStr == "E-155"){
                        f1 = "300.0";
                    }
                    else{}
                    campoFy1.setText(f1);
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {

                }
            });


            spinnerBanzo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                    banzoStr = (String) parent.getItemAtPosition(i);
                    if(banzoStr == "SAE 1020"){
                        fo = "250.0";
                    }
                    else if (banzoStr == "E-155"){
                        fo = "300.0";
                    }
                    else{}
                    campoFyo.setText(fo);
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {

                }
            });


            next = (Button) findViewById(R.id.prosseguir);
            intentNext = new Intent(MainActivity.this, Second.class);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String resistenciaM = campoFy1.getText().toString();
                    String resistenciaB = campoFyo.getText().toString();
                    bundle.putString("fy1",resistenciaM);
                    bundle.putString("fyo",resistenciaB);
                    intentNext.putExtras(bundle);
                    startActivity(intentNext);

                }
            });

        }