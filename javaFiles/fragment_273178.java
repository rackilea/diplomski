// get text from editable text area
String text = editableTA.getText();
// append to non-editble text area
nonEditableTA.append(text + "\n");
editableTA.setText("");  // clear editable
editableTA.requestFocusInWindow(); // give it focus