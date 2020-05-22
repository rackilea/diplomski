Date date = Calendar.getInstance().getTime();
String result = "";
result += new SimpleDateFormat("MMM").format(date).substring(0,1).toLowerCase();
result += new SimpleDateFormat("yy").format(date);
result += Firstnametf.getText().subString(0,3);
result += Lastnametf.getText().subString(0,3);