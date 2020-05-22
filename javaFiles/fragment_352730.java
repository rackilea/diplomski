public class MyResourceBundle {

    private Map<Locale, Map<String, String>> localeResources;


    public MyResourceBundle() {
        localeResources = new HashMap<>();
        for (LocaleConfig config : LocaleConfig.values()) {
            Map<String, String> resources = new HashMap<>();

            ResourceBundle systemTexts = ResourceBundle.getBundle("SystemTexts", config.getLocale());
            ResourceBundle translationTexts = ResourceBundle.getBundle("TranslationTexts", config.getLocale());

            Enumeration systemKeys = systemTexts.getKeys();

            while (systemKeys.hasMoreElements()) {
                String key = (String) systemKeys.nextElement();
                resources.put(key, systemTexts.getString(key));
            }

            Enumeration translationKeys = translationTexts.getKeys();
            while (translationKeys.hasMoreElements()) {
                String key = (String) translationKeys.nextElement();
                resources.put(key, translationTexts.getString(key));
            }

            localeResources.put(config.getLocale(), resources);
        }

    }

    public String getText(Locale locale, String key) {
        String text = null;

        text = localeResources.get(locale).get(key);

        if (text == null) {
            String errorMessage = "Key: " + key + " does not exist for locale " + locale.toString();
            throw new MissingResourceException(errorMessage, this.getClass().getName(), key);
        }

        return text;
    }

}