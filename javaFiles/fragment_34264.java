public class Properties {
    private static java.util.Properties props;

    static {
        props = new java.util.Properties();

        String pathWithPropertiesFiles = System.getProperty("configuration.path");
        String[] paths = pathWithPropertiesFiles.split("[;]");

        Arrays.asList(paths).forEach(propertyPath -> Arrays.asList(Objects.requireNonNull(new File(propertyPath).listFiles())).forEach(propertyFile -> {
            InputStream input;
            try {
                input = new FileInputStream(propertyFile);
                props.load(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    public static String getValue(String key) {
        String envProperty = System.getenv(key);
        if (envProperty != null && !envProperty.equals("null")) {
            return envProperty;
        }

        String systemProperty = System.getProperty(key);
        if (systemProperty != null && !systemProperty.equals("null")) {
            return systemProperty;
        }

        return props.getProperty(key);
    }
}