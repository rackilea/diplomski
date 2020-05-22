// Read from the /assets directory
try {
    InputStream inputStream = assetManager.open("defaultProfile.properties"");
    Properties properties = new Properties();
    properties.load(inputStream);
    System.out.println("The properties are now loaded");
    System.out.println("properties: " + properties);
} catch (IOException e) {
    System.err.println("Failed to open microlog property file");
    e.printStackTrace();
}