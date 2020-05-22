public class EnvironmentVariableParser {
    private static final Log log = LogFactory.getLog(EnvironmentVariableParser.class);

    public static void appendArguments() {
        final String customJvmArgs = System.getenv().get("CUSTOM_JVM_ARGS");
        if (customJvmArgs == null) {
            return;
        }

        for (String entry : customJvmArgs.split(" ")) {
            log.info(String.format("found custom jvm arg for: %s", entry));
            final int separator = entry.indexOf('=');
            System.setProperty(entry.substring(0, separator), entry.substring(separator + 1, entry.length()));
        }
    }
}