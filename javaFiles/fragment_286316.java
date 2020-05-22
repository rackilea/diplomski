public enum Text {
  YELL, SWEAR, BEG, GREET /* and more */ ;

  /** Resources for the default locale */
  private static final ResourceBundle res =
    ResourceBundle.getBundle("com.example.Messages");

  /** @return the locale-dependent message */
  public String toString() {
    return res.getString(name() + ".string");
  }
}