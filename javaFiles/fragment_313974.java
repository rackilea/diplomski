package stackoverflow;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public final class CountriesList {

    private final Map<String, String> map = new TreeMap<>();
    private static CountriesList instance = null;

    private CountriesList() {
        init();
    }

    // static method to create instance of Singleton class
    public static CountriesList getInstance() {
        if (instance == null) {
            instance = new CountriesList();
        }
        return instance;
    }

    public static void main(String[] args) {
        CountriesList list = CountriesList.getInstance();
        System.out.println(list.getCounryCode("da"));
        System.out.println(list.getLanguage("ja"));
        System.out.println(list.getCounryName("en-US"));
        System.out.println(list.get("ar-MA"));
    }

    public String getCounryCode(String code) {
        Locale locale = Locale.forLanguageTag(code);
        if ("".equals(locale.getCountry())) {
            locale = new Locale(code, map.get(code));
        }
        return locale.getCountry();
    }

    public String getCounryName(String code) {
        Locale locale = Locale.forLanguageTag(code);
        if ("".equals(locale.getCountry())) {
            locale = new Locale(code, map.get(code));
        }

        return locale.getDisplayCountry();
    }

    public String getLanguage(String code) {
        Locale locale = Locale.forLanguageTag(code);
        if ("".equals(locale.getCountry())) {
            locale = new Locale(code, map.get(code));
        }

        return locale.getDisplayLanguage();
    }

    public String get(String code) {
        Locale locale = Locale.forLanguageTag(code);
        if ("".equals(locale.getCountry())) {
            locale = new Locale(code, map.get(code));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Language = ").append(locale.getDisplayLanguage());
        sb.append(", Country = ").append(locale.getDisplayCountry());
        sb.append(", Language (Country) = ").append(locale.getDisplayName());
        sb.append("\n");
        return sb.toString();
    }

    // create map with languages and corresponding countries
    public void init() {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            if ((locale.getDisplayCountry() != null) && (!"".equals(locale.getDisplayCountry()))) {
                map.put(locale.getLanguage(), locale.getCountry());
            }
        }
    }
}