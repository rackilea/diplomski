final String a="cout";
    Button okButton = (Button) findViewById(R.id.OK);
    okButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            EditText text = (EditText)findViewById(R.id.Vprasanje1);
            String value = text.getText().toString();
            if(value.equals(a))
            {
                EditText banana = (EditText) findViewById(R.id.Vprasanje1);
                banana.setTextColor(Color.GREEN);
            }