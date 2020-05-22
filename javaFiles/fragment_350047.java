public static File getSettingsDirectory() {
    String userHome = System.getProperty("user.home");
    if(userHome == null) {
        throw new IllegalStateException("user.home==null");
    }
    File home = new File(userHome);
    File settingsDirectory = new File(home, ".myappdir");
    if(!settingsDirectory.exists()) {
        if(!settingsDirectory.mkdir()) {
            throw new IllegalStateException(settingsDirectory.toString());
        }
    }
    return settingsDirectory;
}