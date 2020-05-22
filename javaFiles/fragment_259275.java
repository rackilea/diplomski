public static void main(String[] args) {
    Locale locale = new Locale("en", "US");

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

    try {
        String input = "$123,456,56.2";
        Number money = currencyFormat.parse(input);
        BigDecimal moneyAmount = BigDecimal.valueOf(money.doubleValue());
        //Do whatever you want with money amount here.
    } catch (ParseException pe) {
        pe.printStackTrace();
    }
}