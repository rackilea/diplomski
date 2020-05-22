import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        logger.info("in Main class");
    }
}