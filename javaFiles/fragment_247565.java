public class Config {

    static final File folder = new File(System.getProperty("user.home") + "/Documents/Electrocode Productions/template");
    static final File file = new File(folder, "config.properties");

    public static void add() throws IOException {
        if (file.exists())
            return;

        // create directories as needed.
        folder.mkdirs();

        Properties config = new Properties();
        config.setProperty("log", "true");

        try (OutputStream out = new FileOutputStream(file)) {
            config.store(out, null);
        }
    }

    public static String get(String key, String defaultValue) {
        if (!file.exists())
            return defaultValue;

        try (InputStream in = new FileInputStream(file)) {
            Properties config = new Properties();

            config.load(input);
        } catch(IOException e) {
            Log.error(e);
            return defaultValue;
        }

        String value = config.getProperty(key);
        if (value == null)
            return defaultValue;
        value = value.trim();
        if (value.isEmpty())
            return defaultValue;
        return value;
    }
}