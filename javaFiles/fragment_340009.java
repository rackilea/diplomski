// in some utility class
public static void exitWithError(Throwable e, String msg) {
    dumpStackTraceToFile(e); // something you should have
    JOptionPane.showMessageDialog(null, msg);
    System.exit(1); // force JVM exit when the dialog closes
}

// wherever this should be, only do it once
static final URL GOOGLE;
static {
    try {
        GOOGLE = new URL("http://google.com");
    } catch(MalformedURLException e) {
        exitWithError(e, "Somebody changed the Google URL!");
    }
}