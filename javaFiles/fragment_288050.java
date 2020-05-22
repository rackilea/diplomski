View.OnClickListener listener = new View.OnClickListener() {
    public void onClick(View v) {
        if (((CheckBox)v).isChecked())
            DisplayToast("CheckBox is checked");
        else
            DisplayToast("CheckBox is unchecked");
    }
};

checkBox.setOnClickListener(listener);