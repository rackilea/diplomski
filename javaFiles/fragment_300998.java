EditText mEditText;
@Override onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mEditText = (EditText) findViewById(R.id.edittext);
    mEditText.append("\n");
}