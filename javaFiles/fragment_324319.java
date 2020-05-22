String phonenum = "";
String num = "";

Bundle extras = getIntent().getExtras();
if (extras != null) {
    phonenum = extras.getString("phonenum");
    num = extras.getString("num");
}

phone.setText(phonenum + num);