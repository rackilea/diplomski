String str = Money.getText();
try {
int number = Integer.parseInt(str);
}
catch (NumberFormatException e) {
//What to do if Money did not hold an int?
}