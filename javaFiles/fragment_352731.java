public enum LocaleConfig {

    DANISH("da", "DK"),
    ENGLISH("en", "GB")
    ;

    private String language;
    private String country;

    LocaleConfig(String language, String country) {
        this.language = language;
        this.country = country;
    }

    public Locale getLocale() {
        return new Locale(language, country);
    }
}