Map<Currency, NumberFormat> formatters = new HashMap<>();
...

NumberFormat getCurrencyFormatter(Currency currency) {
    NumberFormat result = formatters.get(currency);
    if (result == null) {
        result = NumberFormat.getCurrencyInstance();
        result.setCurrency(currency);
        formatters.put(currency, result);
    }
    return result;
}