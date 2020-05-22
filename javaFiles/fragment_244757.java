private static final String IN_APPEND_KEY = MyAppender.class.getName() + ".inAppend";
public void append(LoggingEvent e) {
    if (e.getMDC(IN_APPEND_KEY) != null) return;
    MDC.put(IN_APPEND_KEY, this);
    try {
        <your code here>
    } finally {
        MDC.remove(IN_APPEND_KEY);
    }
}