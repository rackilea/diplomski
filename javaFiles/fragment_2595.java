/**
 * Log the message after optionally encoding any special characters that might be dangerous when viewed
 * by an HTML based log viewer. Also encode any carriage returns and line feeds to prevent log
 * injection attacks. This logs all the supplied parameters plus the user ID, user's source IP, a logging
 * specific session ID, and the current date/time.
 *
 * It will only log the message if the current logging level is enabled, otherwise it will
 * discard the message.
 *
 * @param level defines the set of recognized logging levels (TRACE, INFO, DEBUG, WARNING, ERROR, FATAL)
 * @param type the type of the event (SECURITY SUCCESS, SECURITY FAILURE, EVENT SUCCESS, EVENT FAILURE)
 * @param message the message to be logged
 * @param throwable the {@code Throwable} from which to generate an exception stack trace.
 */
private void log(Level level, EventType type, String message, Throwable throwable) {

    // Check to see if we need to log.
    if (!isEnabledFor(level)) {
        return;
    }

    // ensure there's something to log
    if (message == null) {
        message = "";
    }

    // ensure no CRLF injection into logs for forging records
    String clean = message.replace('\n', '_').replace('\r', '_');
    if (ESAPI.securityConfiguration().getLogEncodingRequired()) {
        clean = ESAPI.encoder().encodeForHTML(message);
        if (!message.equals(clean)) {
            clean += " (Encoded)";
        }
    }

    // log server, port, app name, module name -- server:80/app/module
    StringBuilder appInfo = new StringBuilder();
    if (ESAPI.currentRequest() != null && logServerIP) {
        appInfo.append(ESAPI.currentRequest().getLocalAddr()).append(":").append(ESAPI.currentRequest().getLocalPort());
    }
    if (logAppName) {
        appInfo.append("/").append(applicationName);
    }
    appInfo.append("/").append(getName());

    //get the type text if it exists
    String typeInfo = "";
    if (type != null) {
        typeInfo += type + " ";
    }

    // log the message
    // Fix for https://code.google.com/p/owasp-esapi-java/issues/detail?id=268
    // need to pass callerFQCN so the log is not generated as if it were always generated from this wrapper class
    log(Log4JLogger.class.getName(), level, "[" + typeInfo + getUserInfo() + " -> " + appInfo + "] " + clean, throwable);
}