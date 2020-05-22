double noX = 0;
try {
   noX = Double.parseDouble(NumberField.getText());
} catch(NumberFormatException e) {
   System.out.println("Not a valid number");
}
if(noX < 0) {
   System.out.println("Number can not be negative.");
}