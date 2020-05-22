public class ErrorHandler extends StreamHandler {

    public ErrorHandler() {
        setOutputStream(System.err);
    }

    @Override
    public void publish(LogRecord record) {
        super.publish(record);  
        flush();
    }

    @Override
    public void close() {
        flush();
    }

}