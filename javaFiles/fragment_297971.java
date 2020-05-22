//trying to put the TextValue of scanText into tvView
tvView = (TextView)findViewById(R.id.textView9);
tvView.setText(getIntent().getExtras().getString("code_id"));

//You are not getting the string you are just passing the textview
String result = getIntent().getExtras().getString("code_id");

String ServerURL = ("https://asec-domain.000webhostapp.com/select.php?code_id="  + result);