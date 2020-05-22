public final class ExitProgramException extends RuntimeException {

    private final int code;

    public ExitProgramException(int code) { this.code = code; }

    public int getCode() { return code; }
}