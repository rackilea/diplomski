String MyPREFERENCES = "MyPrefs";
        String KEY_DEVICE = "device_id";
        SharedPreferences sharedpreferences;
        SharedPreferences.Editor editor;

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(KEY_DEVICE)) {
            id = sharedpreferences.getString(KEY_DEVICE, "0");
            deviceid.setText(id);
        } else {
            id = String.valueOf(new Random().nextInt(900000) + 100000);
            editor = sharedpreferences.edit();
            editor.putString(KEY_DEVICE, id);
            editor.apply();
            deviceid.setText(id);
        }