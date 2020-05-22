/** Load localized resource for current locale.
 * 
 * @param baseName Basename of the resource. May include a path.
 * @param suffix File extension of the resource.
 * @return URL for the localized resource or null if none was found.
 */
public static URL getLocalizedResource(String baseName, String suffix) {
    Locale locale = Locale.getDefault();
    ResourceBundle.Control control = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
    List<Locale> candidateLocales = control.getCandidateLocales(baseName, locale);

    for (Locale specificLocale : candidateLocales) {
        String bundleName = control.toBundleName(baseName, specificLocale);
        String resourceName = control.toResourceName(bundleName, suffix);

        // Replace "Utils" with the name of your class!
        URL url = Utils.class.getResource(resourceName);
        if (url != null) {
            return url;
        }
    }

    return null;
}