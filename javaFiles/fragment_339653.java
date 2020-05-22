private static final Logger[] pin;
static {
    pin = new Logger[]{
        Logger.getLogger("com.gargoylesoftware.htmlunit"),
        Logger.getLogger("org.apache.commons.httpclient"),
        Logger.getLogger("org.openqa.selenium.remote.ProtocolHandshake")
    };

    for (Logger l : pin) {
        l.setLevel(Level.OFF);
    }
}