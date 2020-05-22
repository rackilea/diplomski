<cfscript>
    // Get the current locale as a java object 
    javaLocale = getPageContext().getResponse().getLocale();

    // get numeric settings for that locale
    currency = createObject("java", "java.text.DecimalFormat").getCurrencyInstance(javaLocale);
    symbols = currency.getDecimalFormatSymbols();

    // 164 => decimal code point for currency sign 
    currencyPattern = currency.toLocalizedPattern();
    result.hasTrailingCurrencySymbol = currencyPattern.indexOf(javacast("int", 164)) > 0;
    result.currencySymbol = symbols.getCurrencySymbol();
    result.decimalSeparator= symbols.getDecimalSeparator();

    WriteDump(result);
</cfscript>