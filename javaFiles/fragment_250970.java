try {
    String string = NumberFormat.getCurrencyInstance(Locale.GERMANY)
                                            .format(123.45);
    Number number = NumberFormat.getCurrencyInstance(locale)
                                            .parse("$123.45");
    // 123.45
    if (number instanceof Long) {
       // Long value
    } else {
       // too large for long - may want to handle as error
    }
} catch (ParseException e) {
// handle
}