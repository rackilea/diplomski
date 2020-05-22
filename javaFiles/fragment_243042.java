System.out.println(
   Currency.getInstance("USD").getSymbol(Locale.US)
);
// prints $

System.out.println(
   Currency.getInstance("USD").getSymbol(Locale.FRANCE)
);
// prints USD

System.out.println(
   Currency.getInstance("EUR").getSymbol(Locale.US)
);
// prints EUR

System.out.println(
   Currency.getInstance("EUR").getSymbol(Locale.FRANCE)
);
// prints €