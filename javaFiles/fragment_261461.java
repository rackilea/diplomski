public static boolean isValidUrl(final String url) {
    try {
        new URL(url);
        return true;
    } catch (MalformedURLException mue) {
        // IGNORE
    }
    return false;
}