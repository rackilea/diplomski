String amountString;
String currencyString;
do {
 System.out.println("Please insert a valid amount and currency");
 String line = input.readLine();
 String[] values = line.split("\\s"); //split on the space
 amountString = values[0];
 currencyString = values[1];

}
while (!isValidAmount(amountString));
while (!isValidCurrencyString(currencyString) {
  System.out.println("Amount accepted but unsupported currency. Please input only the correct currency now");
  currencyString = input.nextLine();
}