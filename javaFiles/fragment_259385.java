@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Configuration configuration = getResources().getConfiguration();
        Locale.setDefault(mCurrentLocale);
        configuration.locale = mCurrentLocale;..locale from preference or latest selected.
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());      
    }