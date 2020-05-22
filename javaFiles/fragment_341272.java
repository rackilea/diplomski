/**
 * Logs {@link Level#INFO} to {@link System#out}.
 * This class is inspired by {@link ConsoleHandler}
 */
public class InfoHandler extends StreamHandler {

    public InfoHandler() {
        setOutputStream(System.out);
        setFilter(new MaxLevelFilter(Level.WARNING));
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