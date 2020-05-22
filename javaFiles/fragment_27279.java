// ResourceBundle.java line 1314
private static ResourceBundle getBundleImpl(String baseName, Locale locale,
                                            ClassLoader loader, Control control) {
    // (...) many lines removed
    // line 1352 - loop through files to find the best one
    ResourceBundle baseBundle = null;
    for (Locale targetLocale = locale;
         targetLocale != null;
         targetLocale = control.getFallbackLocale(baseName, targetLocale)) {
        // line 1356, there you are
        List<Locale> candidateLocales = control.getCandidateLocales(baseName, targetLocale);
        if (!isKnownControl && !checkList(candidateLocales)) {
            throw new IllegalArgumentException("Invalid Control: getCandidateLocales");
        }

        bundle = findBundle(cacheKey, candidateLocales, formats, 0, control, baseBundle);

        // lengthy comment removed for clarity
        if (isValidBundle(bundle)) {
           // checking if it is the right one, removed
        }
    }

    // logic to deal with missing file, removed    
    return bundle;
}