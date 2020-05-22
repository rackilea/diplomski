import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    // Will replace with config values
    private static final String token  = "bottoken";
    private static final String prefix = "!";

    public static void main(String[] args) {
        logger.info("This info to the left is red");
    }
}