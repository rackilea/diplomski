ToggleButton button1 = findViewById(R.id.btn1);
ToggleButton button2 = findViewById(R.id.btn2);
ToggleButton button3 = findViewById(R.id.btn3);
ToggleButton button4 = findViewById(R.id.btn4);

button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // Button1 is checked
        } else {
            // Button1 is unchecked
        }
    }
});