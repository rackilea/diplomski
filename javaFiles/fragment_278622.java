class MyFunctor implements MyFuncInt {

    public final Class<?> clazz;
    private final MyFuncInt func;

    public MyFunctor(Class<?> clazz, MyFuncInt func) {
        this.clazz = clazz;
        this.func = func;
    }

    @Override
    public void doSomething() {
        func.doSomething();     
    }
}