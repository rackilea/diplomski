Locale locale = "LOADYOURLANGUAGE";
Locale.setDefault(locale);
Configuration config = getBaseContext().getResources().getConfiguration();
config.locale = locale;
getBaseContext().getResources().updateConfiguration(config,
getBaseContext().getResources().getDisplayMetrics());