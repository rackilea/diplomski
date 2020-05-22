class Test<T extends X> {
    private Class<T> mClass;
    public Test(Class<T> c) {
        mClass = c;
    }
    public T test() {
        T t = mClass.newInstance();
        return t;
    }
}