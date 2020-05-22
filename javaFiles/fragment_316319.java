YOUR_CHECKBOX_NAME.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        if(YOUR_CHECKBOX_NAME.isChecked()) {
            System.out.println("Checked");
        } else {
            System.out.println("Un-Checked");
        }
    }
});