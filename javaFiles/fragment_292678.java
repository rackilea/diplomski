private static Map<String, Locale> displayNames = new HashMap<String, Locale>();
static {
    for (Locale l : Locale.getAvailableLocales()) {
        displayNames.put(l.getDisplayName(), l);
    }
}

public static Locale getLocale(String displayName) {
    return displayNames.get(displayName);
}