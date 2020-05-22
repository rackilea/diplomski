class A extends RealmObject {
    private B b;
    // Storing the b.name as a field of A when calling setB(). But
    // remember you cannot do it by adding logic to setB() since Realm's
    // proxy will override the setters. You can add a static method to
    // achieve that.
    private String bName;

    // getters and setters

    // This needs to be called in a transaction.
    public static void setBObj(A a, B b) {
        a.setB(b);
        a.setBName(b.getName);
    }
}