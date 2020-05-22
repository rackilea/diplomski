class ActivityHelper {
    public static String initializeSessionId(Bundle savedInstanceState, Activity activity) {
        if (savedInstanceState != null) {
            String newSessionId = savedInstanceState.getString("sessionId");
            if (newSessionId instanceof String) {
                return newSessionId;
            }
        }
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            String newSessionId = extras.getString("sessionId");
            if (newSessionId instanceof String) {
                return newSessionId;
            }
        }
        return null;
    }

    ...
}