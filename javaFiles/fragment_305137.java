public class SipLogWriter extends LogWriter {
    @Override
    public void write(LogEntry entry) {
        Log.d(TAG, getClass().getSimpleName() + " " + entry.getMsg());
    }
}