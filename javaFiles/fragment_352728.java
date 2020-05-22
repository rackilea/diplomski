public String getMessage(Locale locale, String key) {
    String message = key;
    key = key.toString().replace("{", "").replace("}", "");

    PlatformResourceBundleLocator bundleLocator = new PlatformResourceBundleLocator(ResourceBundleMessageInterpolator.DEFAULT_VALIDATION_MESSAGES);
    ResourceBundle resourceBundle = bundleLocator.getResourceBundle(locale);

    try {
       message = ResourceBundle.getString(key);
    }

    catch(MissingResourceException ) {
       message = key;
    }

    return message;
}