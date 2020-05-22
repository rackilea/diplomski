public enum Errors {
    LOGIN_ALREADY_EXISTS(-1, "The username is already in use."),
    UNKNOWN(0, "Unknown");

    private final int errorCode;
    private final String message;

    private Errors(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "#" + errorCode + "#" + message;
    }
}