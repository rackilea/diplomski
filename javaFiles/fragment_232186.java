Locale EASTERN_ARABIC_NUMBERS_LOCALE = new Locale.Builder()
                                                 .setLanguage("ar")
                                                 .setExtension('u', "nu-arab")
                                                 .build();
float f = NumberFormat.getInstance(EASTERN_ARABIC_NUMBERS_LOCALE)
                      .parse("۱٫۵")
                      .floatValue();
System.out.println(f);