public void logoutapp() {
    // TODO Auto-generated method stub
    SharedPreferences.Editor editor = pref.edit();
    boolean isZoomGuide = load("isZoomGuide", false);
    String ip = load("server_ip", "");
    String port = load("server_port", "");
    String db = load("server_db", "");
    editor.clear();
    editor.commit();

    save("isZoomGuide", isZoomGuide);
    save("server_ip", ip);
    save("server_port", port);
    save("server_db", db);
    save("isServer", true);

}