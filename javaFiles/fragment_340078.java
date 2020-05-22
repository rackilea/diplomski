for (Locale locale : Locale.getAvailableLocales()) {
  try {
    Currency c = Currency.getInstance(locale);
    System.out.println(c + "\t" + locale);
  } catch (IllegalArgumentException ignore) { }
}