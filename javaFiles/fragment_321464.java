public class MessageSplittingLogger extends MarkerIgnoringBase {
    //Target size is 64k for split.  UTF-8 nominally has 1 byte characters, but some characters will use > 1 byte so leave some wiggle room
    //Also leave room for additional messages
    private static final int MAX_CHARS_BEFORE_SPLIT = 56000;
    private static final String ENCODING = "UTF-8";
    private Logger LOGGER;

    public MessageSplittingLogger(Class<?> clazz) {
        this.LOGGER = LoggerFactory.getLogger(clazz);
    }

    private void splitMessageAndLog(String msg, Throwable t, Consumer<String> logLambda) {
        String combinedMsg = msg + (t != null ? "\nStack Trace:\n" + printStackTraceToString(t) : "");

        int totalMessages = combinedMsg.length() / MAX_CHARS_BEFORE_SPLIT;
        if(combinedMsg.length() % MAX_CHARS_BEFORE_SPLIT > 0){
            totalMessages++;
        }

        int index = 0;
        int msgNumber = 1;
        while (index < combinedMsg.length()) {
            String messageNumber = totalMessages > 1 ? "(" + msgNumber++ + " of " + totalMessages + ")\n" : "";
            logLambda.accept(messageNumber + combinedMsg.substring(index, Math.min(index + MAX_CHARS_BEFORE_SPLIT, combinedMsg.length())));
            index += MAX_CHARS_BEFORE_SPLIT;
        }
    }

    /**
     * Get the stack trace as a String
     */
    private String printStackTraceToString(Throwable t) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos, true, ENCODING);
            t.printStackTrace(ps);

            return baos.toString(ENCODING);
        } catch (UnsupportedEncodingException e) {
            return "Exception printing stack trace: " + e.getMessage();
        }
    }

    @Override
    public String getName() {
        return LOGGER.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return LOGGER.isTraceEnabled();
    }

    @Override
    public void trace(String msg) {
        LOGGER.trace(msg);
    }

    @Override
    public void trace(String format, Object arg) {
        LOGGER.trace(format, arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        LOGGER.trace(format, arg1, arg2);
    }

    @Override
    public void trace(String format, Object... arguments) {
        LOGGER.trace(format, arguments);
    }

    @Override
    public void trace(String msg, Throwable t) {
        splitMessageAndLog(msg, t, LOGGER::trace);
    }

    //... Similarly wrap calls to debug/info/error
}