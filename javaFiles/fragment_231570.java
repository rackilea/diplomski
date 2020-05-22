public void onClick(View v) {
        if (v.getId() == R.id.BTN_de) {
            languageToLoad = "de";// german
        } else if (v.getId() == R.id.BTN_uk) {
            languageToLoad = "en";// english
        }

        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        this.getBaseContext().getResources().updateConfiguration(config, null);
        Language.lang();
        finish();
    }