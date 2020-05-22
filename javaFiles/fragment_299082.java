@Override
 public void verifyText(VerifyEvent e) {
      char inputChar = e.character;
      int keyCode = e.keyCode;
      String inputString = e.text;
      e.doit = Character.isDigit(inputChar) || keyCode == SWT.BS || keyCode==SWT.DEL||inputString=="";
}