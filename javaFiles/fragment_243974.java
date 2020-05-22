public class MyJetty {

    public static void main(String[] args) throws Exception {
        int PORT = 9103;
        String home = System.getProperty("user.home");
        String logFileDateFormat = "yyyy_MM_dd";

        // execute a request to http://localhost:9103/stop
        // instead of `curl -v http://localhost:9103/stop`
        if (args.length == 1 && "stop".equalsIgnoreCase(args[0])) {
            URL url = new URL("http", "localhost", PORT, "/stop");
            try (InputStream in = url.openStream()) {
                int r;
                while ((r = in.read()) != -1) {
                    System.out.write(r);
                }
                return;
            } catch (IOException ex) {
                System.err.println("stop Jetty failed: " + ex.getMessage());
            }
        }

        Server server = new Server();
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(PORT);
        server.addConnector(connector);
        HandlerCollection handlers = new HandlerCollection();
        NCSARequestLog requestLog = new NCSARequestLog();
        requestLog.setFilename(home + "/logs/access_" + logFileDateFormat + ".log");
        requestLog.setFilenameDateFormat(logFileDateFormat);
        requestLog.setRetainDays(10);
        requestLog.setAppend(true);
        requestLog.setExtended(false);
        requestLog.setLogCookies(false);
        requestLog.setLogTimeZone(TimeZone.getDefault().getID());
        RequestLogHandler requestLogHandler = new RequestLogHandler();
        requestLogHandler.setRequestLog(requestLog);
        handlers.addHandler(requestLogHandler);

        // the class YourHandler is the one from your link
        handlers.addHandler(new YourHandler(server));

        server.setHandler(handlers);
        server.start();
        server.join();
    }
}