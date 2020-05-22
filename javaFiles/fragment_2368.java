where the arguments are:
   1 format - the java.util.Formatter format string specified in the java.util.logging.SimpleFormatter.format property or the default format.
   2 date - a Date object representing event time of the log record.
   3 source - a string representing the caller, if available; otherwise, the logger's name.
   4 logger - the logger's name.
   5 level - the log level.
   6 message - the formatted log message returned from the Formatter.formatMessage(LogRecord) method. It uses java.text formatting and does not use the java.util.Formatter format argument.
   7 thrown - a string representing the throwable associated with the log record and its backtrace beginning with a newline character, if any; otherwise, an empty string.