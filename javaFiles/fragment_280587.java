private BroadcastReceiver myReceiver = new BroadcastReceiver() {

    @Override
    public void onReceive(Context context, Intent intent) {
        String changela = getResources().getConfiguration().locale.getLanguage()
        Intent i = new Intent(Countrylist.this,PhraseDetailActivty.class);
        i.putExtra("KEY",changela);
        startActivity(i);
    }
};

bt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Locale locale = new Locale("ar");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());


           IntentFilter filter = new IntentFilter(Intent.ACTION_LOCALE_CHANGED);
           registerReceiver(myReceiver, filter);
        }
    });