public enum Singleton { 
    INSTANCE;
    private final MyObject myObj = new MyObject(1, 1);

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public synchronized MyObject get() {
        // safe is all you need to do is read one value.
        return myObj;
    }

    public synchronized void update() {
        myObject.setCount(myObject.getCount() + 1);
    }
}