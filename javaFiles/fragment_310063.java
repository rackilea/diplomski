import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;

public class SomeClass2 {

    private static final Logger log = LogManager.getLogger();
    private static final Marker JSON_EVENT = MarkerManager.getMarker("JSON_EVENT");

    public static void main(String[] args){
        ThreadContext.put("userid", "1");
        ThreadContext.put("ipAddress", "127.0.0.1");
        ThreadContext.put("lastConnectionDateTime", "...timestamp...");
        ThreadContext.put("action", "click link 1");
        log.info(JSON_EVENT, "A JSON message uses the special logger");

        log.info("A non-json message uses the normal logger");
    }
}