try {
    is = new BufferedInputStream(new FileInputStream(file));
    Preferences.importPreferences(is);
    Preferences root = Preferences.userRoot();

    Preferences node = Preferences.userRoot().node("Server Settings");

    this.user = node.get("user", "");
    this.url = node.get("url", "");
    this.password = node.get("password", "");
    this.database = node.get("database", "");

    System.out.println(user);
    System.out.println(url);
    System.out.println(password);
    System.out.println(database);

} catch (Exception e) {
    e.printStackTrace();
}