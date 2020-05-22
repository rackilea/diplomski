public class LogFormatter extends Formatter {
  @Override
  public String format(LogRecord record) {
    return new Date(record.getMillis()) + " " + record.getLevel() + ": " + super.formatMessage(record) + "\n";
  }
}