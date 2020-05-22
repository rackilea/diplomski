public enum Singleton { 
    INSTANCE;

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private final Map<Integer, MyObject> map = new HashMap<>();

    public synchronized int getCount(int key) {
        MyObject mo = map.get(key);
        if (mo == null)
            return 1;
        return mo.getCount();
    }

    public synchronized void update(int key) {
        MyObject mo = map.get(key);
        if (mo == null)
            map.put(key, mo = new MyObject(1, 1));
        mo.incrementCount();
    }
}