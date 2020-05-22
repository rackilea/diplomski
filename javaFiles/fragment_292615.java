public void disableSoftInputFromAppearing(EditText editText) {
    if (Build.VERSION.SDK_INT >= 11) {
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);
    } else {
        editText.setRawInputType(InputType.TYPE_NULL);
        editText.setFocusable(true);
    }
}