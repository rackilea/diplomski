String enOrSlReadFromSharedPrefs = readSharedPrefsJustLikeYouDidBefore();
    Locale locale = new Locale(enOrSlReadFromSharedPrefs);
    Locale.setDefault(locale);
    Configuration configSlo = new Configuration();
    configSlo.locale = localeSlo;
    getBaseContext().getResources().updateConfiguration(configSlo, getBaseContext().getResources().getDisplayMetrics());
    Intent intent = new Intent(NastavitveJezika.this, MainActivity.class);
    finish();
    startActivity(intent);