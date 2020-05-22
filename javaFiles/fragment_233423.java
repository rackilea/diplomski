public static void launchApplication(final Class<? extends Application> appClass,
        final String[] args) {

    Class<? extends Preloader> preloaderClass = savedPreloaderClass;

    if (preloaderClass == null) {
        String preloaderByProperty = AccessController.doPrivileged((PrivilegedAction<String>) () ->
                System.getProperty("javafx.preloader"));
        if (preloaderByProperty != null) {
            try {
                preloaderClass = (Class<? extends Preloader>) Class.forName(preloaderByProperty,
                        false, appClass.getClassLoader());
            } catch (Exception e) {
                System.err.printf("Could not load preloader class '" + preloaderByProperty +
                        "', continuing without preloader.");
                e.printStackTrace();
            }
        }
    }

    launchApplication(appClass, preloaderClass, args);
}