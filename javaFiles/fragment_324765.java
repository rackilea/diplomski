public class MultiLayout extends Layout {
  private Layout layout1;
  private Layout layout2;

  public MultiLayout() {
    layout1 = ....;
    layout1.activateOptions();
    layout2 = ....;
    layout2.activateOptions();
  }

  public boolean ignoresThrowable() {
    return layout1.ignoresThrowable();
  }

  public String format(LoggingEvent e) {
    // choose the appropriate layout, e.g. based on logger name
    if(e.getLoggerName().startsWith("com.example.")) {
      return layout1.format(e);
    } else {
      return layout2.format(e);
    }
  }

}