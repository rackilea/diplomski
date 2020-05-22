// To check if service is enabled
private boolean isAccessibilitySettingsOn(Context mContext) {
    int accessibilityEnabled = 0;
    final String service = getPackageName() + "/" + YOURAccessibilityService.class.getCanonicalName();
    try {
        accessibilityEnabled = Settings.Secure.getInt(
                mContext.getApplicationContext().getContentResolver(),
                android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        Log.v(TAG, "accessibilityEnabled = " + accessibilityEnabled);
    } catch (Settings.SettingNotFoundException e) {
        Log.e(TAG, "Error finding setting, default accessibility to not found: "
                + e.getMessage());
    }
    TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

    if (accessibilityEnabled == 1) {
        Log.v(TAG, "***ACCESSIBILITY IS ENABLED*** -----------------");
        String settingValue = Settings.Secure.getString(
                mContext.getApplicationContext().getContentResolver(),
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
        if (settingValue != null) {
            mStringColonSplitter.setString(settingValue);
            while (mStringColonSplitter.hasNext()) {
                String accessibilityService = mStringColonSplitter.next();

                Log.v(TAG, "-------------- > accessibilityService :: " + accessibilityService + " " + service);
                if (accessibilityService.equalsIgnoreCase(service)) {
                    Log.v(TAG, "We've found the correct setting - accessibility is switched on!");
                    return true;
                }
            }
        }
    } else {
        Log.v(TAG, "***ACCESSIBILITY IS DISABLED***");
    }

    return false;
}