String edit1 = et1.getText().toString();
String edit2 = et2.getText().toString();

Log.e("TAG", "First: "+edit1+" Second: "+edit2);

firstSummand = (edit1.isEmpty()) ? 0 : Integer.parseInt(edit1);
secondSummand = (edit2.isEmpty()) ? 0 : Integer.parseInt(edit2);