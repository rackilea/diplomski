mButton.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        String name = mEdit.getText().toString();
        questionOne.setText("Tell me your lucky number, " + name + "!");
    }         
});