public class ClassEnumerator {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Class<?>> list = listClassesInSamePackage(Locator.class, true);

        System.out.println(list);
    }

    private static List<Class<?>> listClassesInSamePackage(Class<?> locator, boolean includeLocator) 
                                                                      throws ClassNotFoundException {

        File packageFile = getPackageFile(locator);

        String ignore = includeLocator ? null : locator.getSimpleName() + ".class";

        return toClassList(locator.getPackage().getName(), listClassNames(packageFile, ignore));
    }

    private static File getPackageFile(Class<?> locator) {
        URL url = locator.getClassLoader().getResource(locator.getName().replace(".", "/") + ".class");
        if (url == null) {
            throw new RuntimeException("Cannot locate " + Locator.class.getName());
        }

        try {
        return new File(url.toURI()).getParentFile();
        }
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] listClassNames(File packageFile, final String ignore) {
        return packageFile.list(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                if (name.equals(ignore)) {
                    return false;
                }
                return name.endsWith(".class");
            }
        });
    }

    private static List<Class<?>> toClassList(String packageName, String[] classNames)
                                                             throws ClassNotFoundException {

        List<Class<?>> result = new ArrayList<Class<?>>(classNames.length);
        for (String className : classNames) {
            // Strip the .class
            String simpleName = className.substring(0, className.length() - 6);

            result.add(Class.forName(packageName + "." + simpleName));
        }
        return result;
    }
}