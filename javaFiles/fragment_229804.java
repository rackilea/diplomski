File torProfileDir = new File(
        "...\\Tor Browser\\Data\\Browser\\profile.default");
FirefoxBinary binary = new FirefoxBinary(new File(
        "...\\Tor Browser\\Start Tor Browser.exe"));
FirefoxProfile torProfile = new FirefoxProfile(torProfileDir);
torProfile.setPreference("webdriver.load.strategy", "unstable");

try {
    binary.startProfile(torProfile, torProfileDir, "");
} catch (IOException e) {
    e.printStackTrace();
}