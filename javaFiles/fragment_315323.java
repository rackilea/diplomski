import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

    private final static Logger log = LogManager.getLogger(Demo.class);

    public static void main(String[] args) throws IOException {
        log.info("starting...");
        try {
            ((Object) null).toString();
        } catch (Exception e) {
            log.error("error message");
        }
        log.info("some info.");
    }
}