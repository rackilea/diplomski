public Configuration(ResourceBundle resourceBundle) {
    try {
        new Configuration(defaultDir, defaultFileName, resourceBundle);
    } catch (IOException | IndexWriteException | IndexReadException e) {
        e.printStackTrace(); 
    }
}