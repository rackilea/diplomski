private void showExemplarCharacterSets(ULocale locale) {
    printSet("Standard:",
            LocaleData.getExemplarSet(locale, LocaleData.ES_STANDARD));
    printSet("Index chars:",
            LocaleData.getExemplarSet(locale, LocaleData.ES_INDEX));
    printSet("Auxiliary:",
            LocaleData.getExemplarSet(locale, LocaleData.ES_AUXILIARY));
    printSet("Punctuation:",
            LocaleData.getExemplarSet(locale, LocaleData.ES_PUNCTUATION));
}

private void printSet(String name, UnicodeSet set) {
    System.out.print(name);
    for (String s : set) {
        System.out.print(" ");
        System.out.print(s);
    }
    System.out.println();
}