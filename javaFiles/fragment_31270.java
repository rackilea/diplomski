class DBusManager {
    static SomeInterface getDBus() {
        try {
            return Class.forName("your.pkg.RealDBus")
                        .getConstructor()
                        .newInstance();
        } catch(ClassNotFoundException e) {
            return new FakeDBus();
        }
    }
}