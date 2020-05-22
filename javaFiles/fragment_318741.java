import java.io.*;

class TracingPrintStream extends PrintStream {
  public TracingPrintStream(PrintStream original) {
    super(original);
  }

  // You'd want to override other methods too, of course.
  @Override
  public void println(String line) {
    StackTraceElement[] stack = Thread.currentThread().getStackTrace();
    // Element 0 is getStackTrace
    // Element 1 is println
    // Element 2 is the caller
    StackTraceElement caller = stack[2];
    super.println(caller.getClassName() + ": " + line);
  }
}

public class Test {
  public static void main(String[] args) throws Exception {
    System.setOut(new TracingPrintStream(System.out));
    System.out.println("Sample line");
  }
}