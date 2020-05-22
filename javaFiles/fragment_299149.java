/**
     * Method is used to check which locatrion mode is selected,
     *
     * @param context
     * @return If return 0 = LOCATION_MODE_OFF, 1 =  LOCATION_MODE_SENSORS_ONLY & DEVICE_ONLY, 2 = LOCATION_MODE_BATTERY_SAVING , 3 = LOCATION_MODE_HIGH_ACCURACY
     */
    public static int getLocationMode(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return 0;
            }
        } else {
            try {
                String locationProviders = Settings.Secure.getString(
                        context.getContentResolver(),
                        Settings.Secure.LOCATION_PROVIDERS_ALLOWED
                );
                if (!TextUtils.isEmpty(locationProviders)) {
                    return 2;
                } else {
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }