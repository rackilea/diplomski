import java.util.prefs.*;

public class Example {
    // Preference key
    private static final String FRUIT = "fruit";

    public void savePreference(String favoriteFruit) {
        Preferences prefs = Preferences.userNodeForPackage(Example.class);

        prefs.put(FRUIT, favoriteFruit);
    }

    public String readPreference() {
        Preferences prefs = Preferences.userNodeForPackage(Example.class);

        return prefs.get(FRUIT, "default");
    }
}