private void saveInSp(String key, boolean value) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("com.altaylar.hdfilmizle2017", android.content.Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    OneSignal.setSubscription(true);
                    Toast.makeText(getApplicationContext(),"Aktif",Toast.LENGTH_LONG).show();
                } else
                    OneSignal.setSubscription(false);
                Toast.makeText(getApplicationContext(),"DeAktif",Toast.LENGTH_LONG).show();
            }
        });
        editor.putBoolean(key, value);
        editor.commit();