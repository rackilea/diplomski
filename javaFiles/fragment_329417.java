public void assumingCorrectNumberFormats(ActionEvent e)
     throws DivideByZeroException {
  String actionCommand = e.getActionCommand();
  String numbers = "1234567890";

  if (numbers.contains(actionCommand)) {
     operand.append(actionCommand);

     // if you need to work with it as a number
     int num = Integer.parseInt(actionCommand);
  }