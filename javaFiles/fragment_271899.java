List<Locale> allAvailableLocales = Arrays.asList(Locale.getAvailableLocales());

private Locale findBestMatch(final List<Locale> requested, final List<Locale> supported) {
    final List<LanguageRange> languageRanges = toLanguageRanges(requested);

    final List<Locale> allMatches = Locale.filter(languageRanges, allAvailableLocales);
    final Locale bestMatch = Locale.lookup(toLanguageRanges(allMatches), supported);

    return bestMatch;
}

private static List<LanguageRange> toLanguageRanges(final List<Locale> locales) {
    final ArrayList<LanguageRange> languageRanges = new ArrayList<>();
    for (final Locale locale : locales) {
        languageRanges.add(toLanguageRange(locale));
    }
    return languageRanges;
}

private static LanguageRange toLanguageRange(final Locale locale) {
    return new LanguageRange(locale.toLanguageTag());
}