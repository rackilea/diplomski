public class MyRollingFileAppender extends RollingFileAppender {

  public MyRollingFileAppender() {
    super();
    init();
  }

  public MyRollingFileAppender(Layout layout, String filename) throws IOException {
    super(layout, filename);
    init();
  }

  public MyRollingFileAppender(Layout layout, String filename, boolean append)
      throws IOException {
    super(layout, filename, append);
    init();
  }

  private void init() {
    this.setMaxFileSize("5MB");
    this.setMaxBackupIndex(20);
    this.setLayout( new PatternLayout("%d %-5p ~ %m%n"));
  }
}