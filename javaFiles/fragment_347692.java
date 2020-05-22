SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    auto.setChecked(settings.getBoolean("auto", false));
    auto.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("auto", auto.isChecked());
                editor.commit();;
            }
        });