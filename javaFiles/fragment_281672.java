EditText txt= (EditText)findViewById(R.id.edittxt); 
TextView textView = (TextView)findViewById(R.id.text); 

txt.addTextChangedListener(new TextWatcher() { 
public void afterTextChanged(Editable s) {

//Code here executes when text in editext changes

textview.setText(txt.getText().toString();
});