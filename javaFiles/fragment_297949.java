public class MockResult implements IResult {

    private boolean cancelled;
    private int result;

    public MockResult(boolean cancelled, int result) {
        this.cancelled = cancelled;
        this.result = result;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public int getResult() {
        return result;
    }
}