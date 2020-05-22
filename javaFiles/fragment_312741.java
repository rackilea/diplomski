button.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {
        message = textField.getText().toString(); //get the text message on the text field
        textField.setText("");      //Reset the text field to blank
        new Asynctask().execute(message);
    }
});