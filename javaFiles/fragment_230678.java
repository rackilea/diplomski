public final class ProjectKey {
    /* prevent instantiation */ private ProjectKey(){}

    private static final String PROJECT_KEY = loadKey();

    public static String getKey () {
        if (PROJECT_KEY != null) return PROJECT_KEY;
        throw new IllegalStateException(
            "Key file not present; find somebody with the file and place in: " +
            "src/main/resources/java/com/yourcompany/yourproject/keys/KeyFile.txt");
    }

    private static String loadKey() {
        InputStream in = ProjectKey.class.getResourceAsStream("KeyFile.txt");
        try {
            return in == null ? null : new Scanner(in, "UTF-8").next();
        } finally {
            if (in != null) in.close();
        }
    }
}