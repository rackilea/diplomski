<T> T makeOne(Class<T> itsClass) throws InstantiationException, IllegalAccessException {
    return itsClass.newInstance();
}

public void test() throws InstantiationException, IllegalAccessException {
    Test aTest = makeOne(this.getClass());
}