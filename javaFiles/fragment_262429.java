private String getJsonFilePath(String fileName) {

    String filePath = "";
    // Reading file within the plugin
    Bundle bundle = Platform.getBundle("com.eclipseplugin.sics");
    // Get the wizard file from the plugin location.
    URL fileURL = bundle.getEntry("lib/" + fileName + ".json");
    try {
        filePath = FileLocator.resolve(fileURL).getPath().substring(1);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return filePath;
}