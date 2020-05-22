class YourClass {
    private volatile Map<String, SomeApplicationObject> map;

    //constructors etc.

    public void reload() {
        Map<String,SomeApplicationObject> newMap = getNewValues();
        map = Collections.unmodifiableMap(newMap);
    }
}