public class ReturnValue {
    public final boolean success;
    public final byte[] result;

    public ReturnValue(boolean success, byte[] result) {
        this.success = success;
        this.result = result;
    }
}