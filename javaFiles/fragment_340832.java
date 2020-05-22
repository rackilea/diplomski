import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class UIBundle {
    private static final Map<Locale, ResourceBundle> allUIResources = new HashMap<Locale, ResourceBundle>();

    public static String getString(final String key) {
        return getString(key, Locale.getDefault());
    }

    public static String getString(final String key, final Locale locale) {
        ResourceBundle rb = allUIResources.get(locale);
        if (rb == null) {
            rb = ResourceBundle.getBundle("my-ui-resource", locale);
            allUIResources.put(locale, rb);
        }
        return rb.getString(key);
    }

}