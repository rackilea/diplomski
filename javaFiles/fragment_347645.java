button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checkBox.isChecked()) {
            //check age is string or not.if not a string means change into String format
            editText3.setText(age + 15);
        } else if (checkBox.isChecked()) {
            editText3.setText(age - 10);
        }
    }
});