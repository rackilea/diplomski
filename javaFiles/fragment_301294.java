public static void setEnvironment(ApplicationEnvironment env) {
    environment = env;
}

public enum ApplicationEnvironment {
    UNKNOWN, PRODUCTION, TEST, DEVELOPMENT
}