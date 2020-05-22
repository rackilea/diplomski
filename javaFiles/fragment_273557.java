public class CustomFilter implements Filter {

 public boolean isLoggable(LogRecord record) {
    return record.getLoggerName().indexOf("com.package.name") != -1;
 }
}