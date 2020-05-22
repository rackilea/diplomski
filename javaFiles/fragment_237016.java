public class Settings {

    private final UserInfo userInfo ;
    private final Preferences prefs ;
    private final Appearance appearance ;

    public Settings(UserInfo userInfo, Preferences prefs, Appearance appearance) {
        this.userInfo = userInfo ;
        this.prefs = prefs ;
        this.appearance = appearance ;
    }

    public Settings() {
        this(new UserInfo(), new Preferences(), new Appearance());
    }

    public UserInfo getUserInfo() {
        return userInfo ;
    }

    public Preferences getPreferences() {
        return prefs ;
    }

    public Appearance getAppearance() {
       return appearance ;
    }
}