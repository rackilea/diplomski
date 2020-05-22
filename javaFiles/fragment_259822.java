public void onClick(View v) {
    messsage = textField.getText().toString(); //get the text message on the text field
    textField.setText("");      //Reset the text field to blank

    new Thread(new SendMessage(message)).start();      // start a new thread to make the communication in the background
}