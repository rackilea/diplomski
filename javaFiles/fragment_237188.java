public static String getAppDataPath() {
    if (System.getProperty("os.name").contains("Windows")) {
        return System.getenv("APPDATA");
    } else {
        return getUnixHome();
    }
}

public static String getUnixHome() {
    String home = System.getProperty("user.home");
    return home != null ? home : "~";
}