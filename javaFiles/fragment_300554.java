android:configChanges="orientation|screenSize|layoutDirection|locale"

@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Locale locale = new Locale(presenter.getLanguage());
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        newConfig.setLocale(locale);
        Locale.setDefault(locale);
        newConfig.setLayoutDirection(locale);
        this.createConfigurationContext(newConfig);
    } else {
        newConfig.locale = locale;
        Locale.setDefault(locale);
        newConfig.setLayoutDirection(locale);
        getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
    }
}