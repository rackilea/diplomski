@Override
protected void onPostExecute(String result) {
    switch (result) {
        case "English":
            locale = new Locale("en");
            Locale.setDefault(locale);
            configuration = new Configuration();
            configuration.locale = locale;
            SaveSharedPreference.setUserLanguage(MainActivity.this, locale.getLanguage());
            getBaseContext().getResources().updateConfiguration(configuration,
                    getBaseContext().getResources().getDisplayMetrics());
            break;
        case "Deutsch":
            locale = new Locale("de");
            Locale.setDefault(locale);
            configuration = new Configuration();
            configuration.locale = locale;
            SaveSharedPreference.setUserLanguage(MainActivity.this, locale.getLanguage());
            getBaseContext().getResources().updateConfiguration(configuration,
                    getBaseContext().getResources().getDisplayMetrics());
            break;
        default:
            locale = Resources.getSystem().getConfiguration().locale;
            Locale.setDefault(locale);
            SaveSharedPreference.setUserLanguage(MainActivity.this, locale.getLanguage());
            configuration = new Configuration();
            configuration.locale = locale;
            getBaseContext().getResources().updateConfiguration(configuration,
                    getBaseContext().getResources().getDisplayMetrics());
            break;
    }
    Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
    if(SaveSharedPreference.getUserType(MainActivity.this).equals("Full")) {
        intent.putExtra("Type", "Full");
    }
    startActivity(intent);
    finish();
}