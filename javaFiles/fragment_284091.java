public class CustomLocaleFxResourceBundleControl extends ResourceBundle.Control {
    static final String FX_BASE_NAME = "com/sun/javafx/scene/control/skin/resources/controls";
    private static final Locale MY_LOCALE = new Locale("pl", "PL");

    @Override
    public String toBundleName(String baseName, Locale locale) {
        if (FX_BASE_NAME.equals(baseName) && MY_LOCALE.equals(locale))
            return "path/to/my/resources/polish"; // without extension

        return super.toBundleName(baseName, locale);
    }
}