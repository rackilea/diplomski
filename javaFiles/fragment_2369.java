in the format string:
   1 date - a Date object representing event time of the log record.
   2 source - a string representing the caller, if available; otherwise, the logger's name.
   3 logger - the logger's name.
   4 level - the log level.
   5 message - the formatted log message returned from the Formatter.formatMessage(LogRecord) method. It uses java.text formatting and does not use the java.util.Formatter format argument.
   6 thrown - a string representing the throwable associated with the log record and its backtrace beginning with a newline character, if any; otherwise, an empty string.