public void handleCheckBoxClick(View view) {
    CheckBox tmpChkBox = (CheckBox) findViewById(view.getId());
    if(tmpChkBox.isChecked())
    {
        tmpChkBox.setBackgroundColor(Color.BLUE);
    }
    else
    {
        tmpChkBox.setBackgroundColor(Color.RED);
    }
}