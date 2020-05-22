import org.apache.commons.lang3.LocaleUtils;

public void setLocales(String[] localeStrings) {
   List<Locale> locales = new ArrayList<Locale>(localeStrings.length);
   for (String localeName: Arrays.asList(localeStrings)) {
      locales.add(LocaleUtils.toLocale(localeName));
   }
   this.locales = locales;
}