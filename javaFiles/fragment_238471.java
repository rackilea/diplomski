DecimalFormatSymbols symbolsEN_US = DecimalFormatSymbols.getInstance(Locale.US);
DecimalFormat formatEN_US = new DecimalFormat("#,###.#", symbolsEN_US);
System.out.println(formatEN_US.format(-123456.789)); // prints -123,456.8

DecimalFormatSymbols symbolsDE_DE = DecimalFormatSymbols.getInstance(Locale.GERMANY);
DecimalFormat formatDE_DE = new DecimalFormat("#,###.#", symbolsDE_DE);
System.out.println(formatDE_DE.format(-123456.789)); // prints -123.456,8

DecimalFormatSymbols symbolsFR_FR = DecimalFormatSymbols.getInstance(Locale.FRANCE);
DecimalFormat formatFR_FR = new DecimalFormat("#,###.#", symbolsFR_FR);
System.out.println(formatFR_FR.format(-123456.789)); // prints -123 456,8

DecimalFormatSymbols symbolsIT_CH = DecimalFormatSymbols.getInstance(Locale.forLanguageTag("it-CH"));
DecimalFormat formatIT_CH = new DecimalFormat("#,###.#", symbolsIT_CH);
System.out.println(formatIT_CH.format(-123456.789)); // prints -123'456.8

DecimalFormatSymbols symbolsHI_IN = DecimalFormatSymbols.getInstance(Locale.forLanguageTag("hi-IN"));
DecimalFormat formatHI_IN = new DecimalFormat("#,###.#", symbolsHI_IN);
System.out.println(formatHI_IN.format(-123456.789)); // prints -१२३,४५६.८

DecimalFormatSymbols symbolsTHAI = DecimalFormatSymbols.getInstance(Locale.forLanguageTag("th-TH-u-nu-thai-x-lvariant-TH"));
DecimalFormat formatTHAI = new DecimalFormat("#,###.#", symbolsTHAI);
System.out.println(formatTHAI.format(-123456.789)); // prints -๑๒๓,๔๕๖.๘