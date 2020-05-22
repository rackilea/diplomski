ULocale germanLocale = ULocale.forLanguageTag("de-DE");
LocaleData localeData = LocaleData.getInstance(germanLocale);
String openningQuotation = localeData
        .getDelimiter(LocaleData.QUOTATION_START);
String closingQuotation = localeData
        .getDelimiter(LocaleData.QUOTATION_END);
String quoted = MessageFormat.format("{0}{2}{1}", openningQuotation,
        closingQuotation, "Das buch");
System.out.println(quoted);