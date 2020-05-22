ResourceBundle rb=ResourceBundle.getBundle("Resources", new ResourceBundle.Control() {
  @Override
  public long getTimeToLive(String baseName, Locale locale) {
    return Long.MAX_VALUE;
  }
  @Override
  public ResourceBundle newBundle(String baseName, Locale locale,
      String format, ClassLoader loader, boolean reload)
      throws IllegalAccessException, InstantiationException, IOException {
    return super.newBundle(baseName, locale, format, defaultLoader, reload);
  }
});