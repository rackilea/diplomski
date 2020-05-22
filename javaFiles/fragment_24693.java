public static void main(String[] args) throws IOException {

    // Selenium
    WebDriver driver = new FirefoxDriver(createFirefoxProfile());
    driver.get("ANY URL HERE");
    String html_content = driver.getPageSource();
    driver.close();

    // Jsoup makes DOM here by parsing HTML content
    // OPERATIONS USING DOM TREE
}

private static FirefoxProfile createFirefoxProfile() {
    File profileDir = new File("/tmp/firefox-profile-dir");
    if (profileDir.exists())
        return new FirefoxProfile(profileDir);
    FirefoxProfile firefoxProfile = new FirefoxProfile();
    File dir = firefoxProfile.layoutOnDisk();
    try {
        profileDir.mkdirs();
        FileUtils.copyDirectory(dir, profileDir);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return firefoxProfile;
}