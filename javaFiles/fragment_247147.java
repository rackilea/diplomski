class A<T extends A> {
    private T one() { return (T) this;}

    protected T two() { return (T) this;}

    protected void three() { ((A)two()).one(); }
}