class MyGenericObject<T> {
    private final Class<T> theClass;
    public Class<T> getTypeArg() {
        return theClass;
    }
    MyGenericObject(Class<T> theClass, ... the rest of constructor parameters) {
        this.theClass = theClass;
        ... the rest of the constructor ...
    }
}