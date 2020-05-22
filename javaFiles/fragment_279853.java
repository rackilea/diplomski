Set<Locale> locales = new HashSet<>();
Collections.addAll(locales, Locale.getAvailableLocales());

Locale locale = new Locale("xx", "xx");
System.out.println(locales.contains(locale)); //prints false

locale = new Locale("fr", "FR");
System.out.println(locales.contains(locale)); //prints true