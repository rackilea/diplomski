String calorie = getIntent().getStringExtra("calorie");
TextView textView1 = (TextView)findViewById(R.id.textView1);

String strOldValue = textView1.getText().toString();
//Integer oldValue = StringUtils.isNotBlank(myString) ? Integer.parseInt(myString) : 0;

//UPDATE: Replace above with
//Integer oldValue = (myString != null && !myString.isEmpty()) ? Integer.parseInt(myString) : 0;

//UPDATE:
Integer oldValue = 0;
try {
    oldValue = Integer.parseInt(myString);
} catch(Exception e) {
    //oldValue = 0;
}

Integer newValue = Integer.parseInt(calorie);

textView1.setText((oldValue + newValue));