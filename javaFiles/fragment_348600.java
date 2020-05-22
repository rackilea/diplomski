String country = "Japonia";
Locale outLocale = Locale.forLanguageTag("en_GB");
Locale inLocale = Locale.forLanguageTag("pl-PL");
for (Locale l : Locale.getAvailableLocales()) {
    if (l.getDisplayCountry(inLocale).equals(country)) {
        System.out.println(l.getDisplayCountry(outLocale));
        break;
    }
}