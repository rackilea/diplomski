Button calc = (Button) findViewById(R.id.btn_converter);
calc.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View arg0) {
        Textview t1 = (TextView) findViewById(R.id.txt_cad_alis);
        String value = t1.getText().toString();
        Intent myIntent = new Intent(MainActivity.this, Calculator.class);
        intent.putExtra("aKey", value);
        MainActivity.this.startActivity(myIntent);
    }
});