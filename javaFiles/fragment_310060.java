import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;


public class SomeClass {

    private static final Logger log = LogManager.getLogger();
    private static final Logger JSON_EVENT_LOGGER = LogManager.getLogger("JSON_EVENT_LOGGER");

    public static void main(String[] args){
        ThreadContext.put("userid", "1");
        ThreadContext.put("ipAddress", "127.0.0.1");
        ThreadContext.put("lastConnectionDateTime", "...timestamp...");
        ThreadContext.put("action", "click link 1");
        JSON_EVENT_LOGGER.info("A JSON message uses the special logger");

        log.info("A non-json message uses the normal logger");
    }
}