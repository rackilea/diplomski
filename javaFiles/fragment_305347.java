public class Context {
    public static final String PREF_UTILITY_FILE_NAME = "PrefUtilityFile";

    public Facebook fb;
    public AsyncFacebookRunner fbAsyncRunner;
    public String[] fbPermissions = {"email", "read_stream", "user_birthday"};
    public SharedPreferences prefs;
    public Editor editor;
    public String access_token;
    public long expires;
}

// pass to constructor as required
class UsesContext {
    final Context context;
    public UsesContext(Context context) {
        this.context = context;
    }

    public void method() {
        // can use context
    }
}