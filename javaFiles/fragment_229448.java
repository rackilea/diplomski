String emailtxt1 = text1.getText().toString();
String emailtxt2 = text2.getText().toString();
String emailtxt3 = text3.getText().toString();
String emailtxt4 = text4.getText().toString();
String emailtxt5 = text5.getText().toString();

String emailTxt = "";

Intent intent = new Intent(Intent.ACTION_SEND);
intent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
intent.putExtra(Intent.EXTRA_SUBJECT, "Tasks");

if (check1.isChecked()){
    emailTxt = emailTxt + "\n" + emailtxt1;
}
if (check2.isChecked()){
    emailTxt = emailTxt + "\n" + emailtxt2;
}
if (check3.isChecked()){
    emailTxt = emailTxt + "\n" + emailtxt3;
}
if (check4.isChecked()){
    emailTxt = emailTxt + "\n" + emailtxt4;
}
if (check5.isChecked()){
    emailTxt = emailTxt + "\n" + emailtxt5;
}

intent.putExtra(Intent.EXTRA_TEXT, emailTxt);
intent.setType("message/rfc822");
startActivity(Intent.createChooser(intent, "Choose an emailTxt client"));