public final class Env {

    public static final PropertiesHolder FIRST = new PropertiesHolder("path/properties1.file");
    public static final PropertiesHolder SECOND = new PropertiesHolder("path/properties2.file");
    ...

    public static class PropertiesHolder {

        private final String path;
        private final Properties properties;

        public PropertiesHolder(String path) {
            ...
        }

        public String getPropertyA() {
            ...
        }

        public String getPropertyB() {
            ...
        }
    }
}