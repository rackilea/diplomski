TextHandler handler = new TextHandler();
textField1.addActionListener(handler);
textField2.addActionListener(handler);
textField3.addActionListener(handler);
passwordField.addActionListener(handler);

// Create an instance of our button handler and add that to our button instead of the
// other handler.
MyButtonHandler buttonHandler = new MyButtonHandler();
button.addActionListener(buttonHandler);