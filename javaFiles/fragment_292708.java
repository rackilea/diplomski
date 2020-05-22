public enum ApplicationType {
    transport(0),
    exposure(1),
    manufacture(2),
    factoryhub(3);

    private int code;

    ApplicationType(int code) {
        this.code = code;
    }

    public static ApplicationType parse(String name) {
        return ApplicationType.valueOf(name.toLowerCase());
    }

    public int getCode() {
        return code;
    }
}