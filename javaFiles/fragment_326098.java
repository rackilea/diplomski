View child = tableRow.getChildAt(1);

if (child instanceof EditText) {
    EditText et = (EditText) child;
    et.setText("Some Text");
}