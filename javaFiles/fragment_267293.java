public class CustomManager {
  private static final Map BUNDLES = new HashMap();

  public static ResourceBundle getBundle(String name, Set languages) {
    Locale locale = Locale.getDefault();
    if (languages.contains(locale.getLanguage())) {
      name = name + "_" + locale.getLanguage();
    }
    synchronized (BUNDLES) {
      ResourceBundle bundle = (ResourceBundle) BUNDLES.get(name);
      if (bundle == null) {
        ClassLoader loader = getContextClassLoader();
        bundle = loadBundle(loader, name.replace('.', '/') + ".properties");
        BUNDLES.put(name, BUNDLES);
      }
      return bundle;
    }
  }

  private static ClassLoader getContextClassLoader() {
    return Thread.currentThread().getContextClassLoader() != null ? Thread
        .currentThread().getContextClassLoader() : CustomManager.class
        .getClassLoader() != null ? CustomManager.class.getClassLoader()
        : ClassLoader.getSystemClassLoader();
  }

  private static ResourceBundle loadBundle(ClassLoader loader, String res) {
    try { InputStream in = loader.getResourceAsStream(res);
      try { return new PropertyResourceBundle(in);
      } finally { in.close(); }
    } catch (IOException e) { throw new IllegalStateException(e.toString()); }
  }
}