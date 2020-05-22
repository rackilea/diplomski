if(editstr.contentEquals(lname)) {
    edit3.setText("Enter value");
} else {
    a=Double.parseDouble(edit.getText().toString()); // else add the stuff
    b=Double.parseDouble(edit2.getText().toString());
    c=a+b;
    edit3.setText(Double.toString(c));
}