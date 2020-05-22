public enum Enum {
    LOW("-1"), NOT_DETERMINED("0"), HIGH("1");
    private String code;
    private Enum(String c) {
        this.code = c;
    }

    public String getCode() {
        return this.code;
    }

    public static Enum getEnum(String code) {
        switch (code) {
            case "-1":
                return LOW;
            case "0":
                return NOT_DETERMINED;
            case "1":
                return HIGH;
            default:
                return null;
        }
    }
}