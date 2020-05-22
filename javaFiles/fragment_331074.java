// other imports
import com.google.appengine.tools.development.DevAppServerMain;

public class DevServer {
    public static void launch(final String[] args) {
        Logger logger = Logger.getLogger("");
        logger.info("Launching AppEngine server...");
        Thread server = new Thread() {
            @Override
            public void run() {
                try {
                    DevAppServerMain.main(args);  // run DevAppServer
                } catch (Exception e) { e.printStackTrace(); }
            }
        };
        server.setDaemon(true);  // shut down server when rest of app completes
        server.start();          // run server in separate thread
        URLConnection cxn;
        try {
            cxn = new URL("http://localhost:8888").openConnection();
        } catch (IOException e) { return; }  // should never happen
        boolean running = false;
        while (!running) {  // maybe add timeout in case server fails to load
            try {
                cxn.connect();  // try to connect to server
                running = true;
                // Maybe limit rate with a Thread.sleep(...) here
            } catch (Exception e) {}
        }
        logger.info("Server running.");
    }
}