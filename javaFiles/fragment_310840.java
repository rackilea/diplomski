Bundle extras = getIntent().getExtras();
 String unitType = extras.getString("unitType");
 if (unitType.equals("marine")) {
 TextView unitNameView = (TextView) findViewById(R.id.textViewUnitName);
    unitNameView.setText("Marine!");
 }