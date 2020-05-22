public static void main(String[] args) throws Exception {
    SimpleClassLoader cl = new SimpleClassLoader();
    Class<?> cls = cl.loadClass("foo.Bar");
    cls.newInstance(); // this triggers resolution

    cl.printLoadedClass("foo.Bar");
    cl.printLoadedClass("foo.Baz");
}