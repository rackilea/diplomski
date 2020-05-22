if(Callable.class.isAssignableFrom(clazz)) {
    Callable obj = (Callable) clazz.newInstance();

} else if (MyAbstractClass.class.isAssignableFrom(clazz)) {
    MyAbstractClass obj = (MyAbstractClass) clazz.newInstance();

} else {
    throw new IllegalArgumentException(clazz+" not valid");
}