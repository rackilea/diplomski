public enum Status {


    OPEN("1"),
    CLOSED("2"),
    DELETED("3");

    private String code;

    public Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}