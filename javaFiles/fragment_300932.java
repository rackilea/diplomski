public final class Preferences {
    private static Context sContext;

    private Preferences() {
        throw new AssertionError("Utility class; do not instantiate.");
    }

    /**
     * Used to initialize a context for this utility class. Recommended
     * use is to initialize this in a subclass of Application in onCreate()
     *
     * @param context a context for resolving SharedPreferences; this
     *                will be weakened to use the Application context
     */
    public static void initialize(Context context) {
        sContext = context.getApplicationContext();
    }

    private static void ensureContext() {
        if (sContext == null) {
            throw new IllegalStateException("Must call initialize(Context) before using methods in this class.");
        }
    }

    private static SharedPreferences getPreferences() {
        ensureContext();
        return sContext.getSharedPreferences(SHARED_PREFS_FILE, 0);
    }

    private static SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }

    public static void addEventId(String eventId) {
        final Set<String> events = getPreferences().getStringSet(MY_EVENTS, new HashSet<String>());

        if (events.add(eventId)) {
            // Only update the set if it was modified
            getEditor().putStringSet(MY_EVENTS, events).apply();
        }
    }

    public static Set<String> getEventIds() {
        return getPreferences().getStringSet(MY_EVENTS, new HashSet<String>());
    }
}