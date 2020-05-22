private static String getProtocol() {
    if (Window.Location.getProtocol().equals("https:")) {
        return "https:";
    }
    return "http:";
}