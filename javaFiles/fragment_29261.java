private void JTextFeild1KeyTyped(java.awt.event.KeyEvent evt) {
  String num1 = JTextFeild1.getText();
  if (!num1.startsWith("ADZ"))
  {
    num1 = "ADZ" + num1;
    JTextFeild1.setText(num1);
  }
  ...
}