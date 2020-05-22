import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

  private static final Logger logger = LogManager.getLogger();
  public static void main (String[] args) {
    logger.info("Text: {}", lazy( ()->getText() ));
    logger.error("Text: {}", lazy(Log4jTest::getText));
  }
  // reusable helper method
  static Object lazy(Supplier<String> s) {
    return new Object() {
      @Override
      public String toString() {
          return s.get();
      }
    };
  }
  static String getText() {
    System.out.println("very long computation");
    return "";
  }
}