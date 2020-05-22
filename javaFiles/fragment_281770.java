NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);

System.out.println("75.13 euro: " + numberFormat.format(75.13));

try {
  System.out.println("Parsed blam1: " + numberFormat.parse("EUR 75,11"));
} catch (ParseException exception) {
  System.out.println("Parse Exception1: " + exception);
}

try {
  System.out.println("Parsed blam2: " + numberFormat.parse("75,12 €"));
} catch (ParseException exception) {
  System.out.println("Parse Exception2: " + exception);
}

try {
  System.out.println("Parsed blam3: " + numberFormat.parse("€ 75,13"));
} catch (ParseException exception) {
  System.out.println("Parse Exception3: " + exception);
}