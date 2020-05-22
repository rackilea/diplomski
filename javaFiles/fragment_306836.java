static public void displayNumber(Locale currentLocale) {

Integer quantity = new Integer(123456);
Double amount = new Double(345987.246);
NumberFormat numberFormatter;
String quantityOut;
String amountOut;

numberFormatter = NumberFormat.getNumberInstance(currentLocale);
quantityOut = numberFormatter.format(quantity);
amountOut = numberFormatter.format(amount);
System.out.println(quantityOut + "   " + currentLocale.toString());
System.out.println(amountOut + "   " + currentLocale.toString());
}