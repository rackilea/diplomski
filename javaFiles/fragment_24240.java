public class SimpleClassLoader extends ClassLoader {

    static final String PATH = "/path/to/classes";

    public SimpleClassLoader() {
        // disable parent delegation
        super(null);
    }

    public void printLoadedClass(String name) throws Exception {
        Class<?> cls = findLoadedClass(name);
        System.err.println("findLoadedClass(" + name + ") = " + cls
                + ", has class loader " + cls.getClassLoader());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.equals("foo.Baz")) {
            // don't want to be defining class loader of foo.Baz
            return getSystemClassLoader().loadClass(name);
        }
        // now we're loading foo.Bar
        try {
            byte[] b = IOUtils.toByteArray(new FileInputStream(PATH + "/foo/Bar.class"));
            return defineClass(name, b, 0, b.length);
        } catch (ClassFormatError | IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}