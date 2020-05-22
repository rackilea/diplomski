Locale locale = new Locale("ar”,"XX");

 private void updateLocale(locale) {
    final Configuration configuration = getResources().getConfiguration();
    Locale.setDefault(baseLocal);
    configuration.locale = baseLocal;
    getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
}