static private class MyJSchLogger implements com.jcraft.jsch.Logger {
    private java.util.logging.Logger logger;

    public MyJSchLogger(java.util.logging.Logger logger) {
        this.logger = logger;
    }

    public boolean isEnabled(int level){
        return true;
    }
    public void log(int level, String message){
        java.util.logging.Level l;
        switch (level)
        {
        case com.jcraft.jsch.Logger.DEBUG:
            l = java.util.logging.Level.FINE;
            break;
        case com.jcraft.jsch.Logger.INFO:
            l = java.util.logging.Level.INFO;
            break;
        case com.jcraft.jsch.Logger.WARN:
            l = java.util.logging.Level.WARNING;
            break;
        default:
        case com.jcraft.jsch.Logger.ERROR:
        case com.jcraft.jsch.Logger.FATAL:
            l = java.util.logging.Level.SEVERE;
            break;
        }
        this.logger.log(l, message);
    }
}