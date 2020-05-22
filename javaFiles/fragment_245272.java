@Override
protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
    TextView text = (TextView) findViewById(R.id.txtView1);
    EditText editBox = (EditText)findViewById(R.id.txtBox1);
    String str = text.getText().toString();
    text.setText(str+" "+editBox.getText().toString());
    editBox.setText("");
    editBox.setHint("Type in here");

}