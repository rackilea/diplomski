public static Currency getCurrencyInstance(int numericCode) {
    Set<Currency> currencies = Currency.getAvailableCurrencies();
    for (Currency currency : currencies) {
        if (currency.getNumericCode() == numericCode) {
            return currency;
        }
    }
    throw new IllegalArgumentException("Currency with numeric code "  + numericCode + " not found");
}