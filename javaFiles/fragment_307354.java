class Foo<T> {
    private final Class<T> genericClass;

    public Foo(Class<T> clazz) {
        this.genericClass = clazz;
    }

    protected boolean validateType(Object obj){
        return genericClass.isInstance(obj);
    }
}