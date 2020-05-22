public boolean onLongClick(View v) {
    EditText text1 = (EditText) findViewById(R.id.EditText1);
    text1.setText("");
    Toast.makeText(getApplicationContext(), "The text is gone!", Toast.LENGTH_SHORT).show();
    return false;
}