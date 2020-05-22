package so35592962;
import org.apache.logging.log4j.*;
import so35592962.sub.OtherClass;
public class App {
  public static final Logger logger = LogManager.getLogger();
  public static void main(String[] args) {
    logger.error("in App.main");
    OtherClass.act();
  }
}