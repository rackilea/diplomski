public enum SystemType {
    PRODUCTION,
    TESTING,
    DEVELOPMENT;

    public final SystemType CURRENT;

    static {
        String type = System.getEnv("system.type");
        if ("PROD".equals(type)) {
            CURRENT = PRODUCTION;
        } else if ("TEST".equals(type)) {
            CURRENT = TESTING;
        } else {
            CURRENT = DEVELOPMENT;
        }
    }
}