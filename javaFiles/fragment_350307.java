import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.log4j.Logger;

public class RecursiveLogging {
  /**
   * log4j.properties file:
   * 
   * log4j.rootLogger=DEBUG, A1
   * log4j.appender.A1=org.apache.log4j.ConsoleAppender
   * log4j.appender.A1.layout=org.apache.log4j.PatternLayout
   * log4j.appender.A1.layout.ConversionPattern=%-4r [%t] %-5p %c %x - %m%n
   * 
   */
  public static void main(String[] args) {
    // Logger.getLogger(RecursiveLogging.class).info("This initializes log4j!");
    System.setOut(new PrintStream(new CustomOutputStream()));
    System.out.println("This message causes a stack overflow exception!");
  }
}

class CustomOutputStream extends OutputStream {
  @Override
  public final void write(int b) throws IOException {
    // the correct way of doing this would be using a buffer
    // to store characters until a newline is encountered,
    // this implementation is for illustration only
    Logger.getLogger(CustomOutputStream.class).info((char) b);
  }
}