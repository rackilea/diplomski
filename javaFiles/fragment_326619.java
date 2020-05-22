class AChange<T extends A> {
    protected T instance;

    public String doSomething() {
        return instance.getName();
    }
}