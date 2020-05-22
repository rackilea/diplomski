class Singleton
{
    private Singleton() { } // not accessible
    private static Class LazyHolder {
        private static final Singleton LAZY_HIGHLANDER = new Singleton();
    }
    public static Singleton getInstance() {
        return LazyHolder.LAZY_HIGHLANDER;
    }
}