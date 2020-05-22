public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main);
    mDisplay = (TextView) findViewById(R.id.display);

    context = getApplicationContext();
    regid = getRegistrationId(context);

    if (regid.length() == 0) {
        registerBackground();
    }
    gcm = GoogleCloudMessaging.getInstance(this);
}

/**
 * Gets the current registration id for application on GCM service.
 * <p>
 * If result is empty, the registration has failed.
 *
 * @return registration id, or empty string if the registration is not
 *         complete.
 */
private String getRegistrationId(Context context) {
    final SharedPreferences prefs = getGCMPreferences(context);
    String registrationId = prefs.getString(PROPERTY_REG_ID, "");
    if (registrationId.length() == 0) {
        Log.v(TAG, "Registration not found.");
        return "";
    }
    // check if app was updated; if so, it must clear registration id to
    // avoid a race condition if GCM sends a message
    int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
    int currentVersion = getAppVersion(context);
    if (registeredVersion != currentVersion || isRegistrationExpired()) {
        Log.v(TAG, "App version changed or registration expired.");
        return "";
    }
    return registrationId;
}

/**
 * Checks if the registration has expired.
 *
 * <p>To avoid the scenario where the device sends the registration to the
 * server but the server loses it, the app developer may choose to re-register
 * after REGISTRATION_EXPIRY_TIME_MS.
 *
 * @return true if the registration has expired.
 */
private boolean isRegistrationExpired() {
    final SharedPreferences prefs = getGCMPreferences(context);
    // checks if the information is not stale
    long expirationTime =
            prefs.getLong(PROPERTY_ON_SERVER_EXPIRATION_TIME, -1);
    return System.currentTimeMillis() > expirationTime;
}