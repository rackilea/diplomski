for (Locale targetLocale = locale;
     targetLocale != null;
     targetLocale = control.getFallbackLocale(baseName, targetLocale)) {
         List<Locale> candidateLocales = control.getCandidateLocales(baseName, targetLocale);
         ...
}