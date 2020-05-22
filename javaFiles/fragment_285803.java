@Override
protected void onCreate(Bundle savedInstanceState) {

    ...

    EditText wiekEditText = (EditText) findViewById(R.id.inWiek);
    EditText tspoczEditText = (EditText) findViewById(R.id.inTspocz);

    // edit text are still empty...
    int wiek = Integer.parseInt(wiekEditText.getText().toString()); // error occurs!
    int tspocz = Integer.parseInt(tspoczEditText.getText().toString());

    ...

}