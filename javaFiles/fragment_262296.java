package org.nbk.demo;
import org.apache.log4j.Logger;
public class ServerStartup {
    private static final Logger logger = Logger.getLogger(ServerStartup.class);
    public void onApplicationEvent() {
            logger.info("Information Messages");
    }
}