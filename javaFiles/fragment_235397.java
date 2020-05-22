public class CustomWebappClassLoader extends WebappClassLoader {

    public CustomWebappClassLoader() {
        super();
        addCustomRepository();
    }

    public CustomWebappClassLoader(ClassLoader parent) {
        super(parent);
        addCustomRepository();
    }

    private void addCustomRepository() {
        String catalinaHome = System.getProperty("catalina.home");
        File dir = new File(catalinaHome, String.format("extensions%slib", File.separator));
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith(".jar")) {
                String repository = String.format("file:/%s", file.getAbsolutePath());
                addRepository(repository);
            }
        }
    }
}