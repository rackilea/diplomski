public static Configuration fromResourceBundle(ResourceBundle resourceBundle) {
    try {
        return new Configuration(defaultDir, defaultFileName, resourceBundle);
    } catch (IOException | IndexWriteException | IndexReadException e) {
        // Swallowing exceptions? Really?
        e.printStackTrace();
        // At least the caller will get a null reference back instead of
        // a broken object...
        return null;
    }
}