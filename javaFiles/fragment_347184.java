public abstract class MyAppBase {
 public abstract String[] getSpringConfigResource();
 public void loadConsoleApplication() {
  try {
   preLoad();
   initializeSpring();
   loadConfiguration();
   loadDynamicComponents();
   postApplicationLoad();
  }
  catch (Exception ex) {
   handleStartupException("error initialzing application", ex);
  }
 }
 ...
}