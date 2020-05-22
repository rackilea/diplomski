getApplicationContext().getContentResolver().registerContentObserver(
    Settings.Secure.getUriFor("adb_port"), false, 
        new ContentObserver() {

            @Override
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                Integer intPort = Settings.Secure.getInt(getContentResolver(), "adb_port", -1);
                if (intPort > -1)  {
                    System.out.println("Enabled");
                } else {
                    System.out.println("Disabled");
                }
            }

});