public static ComponentOrientation getOrientation(Locale locale) {
    String lang = locale.getLanguage();
    if ("iw".equals(lang) || "ar".equals(lang) || "fa".equals(lang) || "ur".equals(lang)) {
        return RIGHT_TO_LEFT;
    } else {
        return LEFT_TO_RIGHT;
    }
}