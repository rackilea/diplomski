int x = 0;
try {
    x = Integer.parseInt(textField.getText());
} catch (NumberFormatException e) {
    System.out.println("Not a number");
}