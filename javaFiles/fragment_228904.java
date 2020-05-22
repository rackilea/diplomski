public void OnAdd(View v) {
    v1 = Double.parseDouble(total);
    Button button = (Button) v;
    String str = button.getText().toString();
    sign = str;
    total += str;
    EditText edit = (EditText) findViewById(R.id.editText);
    edit.setText(total);
}