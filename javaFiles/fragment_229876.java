public class SimpleEula {

    private String EULA_PREFIX = "eula";
    private Activity mActivity;

    public SimpleEula(Activity context) {
        mActivity = context;
    }

    public void show() {
        final String eulaKey = EULA_PREFIX;
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mActivity);
            ...