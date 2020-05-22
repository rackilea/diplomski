public enum PhotPropertiesManager {;
    private static final Properties PHOT_PROPERTIES = new Properties();

    static {
        try {
            load("defaultphot");
            load("lastexecutionphot");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void load(String filename) throws IOException {
        FileInputStream in = new FileInputStream(filename);
        PHOT_PROPERTIES.load(in);
        in.close();
    }

    public static Properties getPhotProperties() {
        return PHOT_PROPERTIES;
    }
}