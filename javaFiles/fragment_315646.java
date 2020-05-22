protected void onCreate (Bundle savedInstanceState) {
    ...
    String sysLang = Locale.getDefault().getLanguage();
    String i18nLang;
    if ((sysLang == "en") || (sysLang == "de")) {
        i18nLang = "en";
    } else if (...) {...}

    initialize(new MyGame(i18nLang), config);
}