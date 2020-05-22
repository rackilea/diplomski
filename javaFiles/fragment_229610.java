TextView Year = (TextView)findViewById(R.id.Year);
    TextView Capacity = (TextView)findViewById(R.id.Capacity);
    editYear = (EditText)findViewById(R.id.editYear);
    editCapacity = (EditText)findViewById(R.id.editCapacity);
    Result = (EditText)findViewById(R.id.Result);
    Button   calc =(Button)findViewById(R.id.calc);
    final RadioButton RadioD = (RadioButton)findViewById(R.id.radioD);
    final RadioButton RadioB = (RadioButton)findViewById(R.id.radioB);

    calc.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            double editYear = editYear.getText().toString();
            double editCapacity = editYear.getText().toString();

            if(RadioB.isChecked()){
                switch(editYear){
                case 2014:
                    if(editCapacity >0 && NCapacity <1000){
                        Result = editCapacity*0.57;

                }
                    if(editCapacity >1000 && editCapacity <1500){
                        Result = editCapacity*0.67;

                }
                    if(editCapacity >1501 && editCapacity <2000){
                        Result = editCapacity*1.00;

                }
                break;
            }

        }
                } // <-- add this here
    });
}