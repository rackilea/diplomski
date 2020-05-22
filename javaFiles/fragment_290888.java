public class LoggerFactory {
  public static Logger make() {
    Throwable t = new Throwable();
    StackTraceElement directCaller = t.getStackTrace()[1];
    return Logger.getLogger(directCaller.getClassName());
  }
}

...

public class BetterApplication {
  private final static Logger logger = LoggerFactory.make();

  ...
}