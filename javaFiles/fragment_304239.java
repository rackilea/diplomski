class Singleton
{
    private static final Singleton HIGHLANDER = new Singleton();
    private Singleton() { } // not accessible
    public static getSingleton() { return HIGHLANDER; }
}