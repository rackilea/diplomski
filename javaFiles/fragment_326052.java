public static interface MyInterface<E extends Throwable>{
    void call() throws E;
}

public static <E extends Throwable> void method(MyInterface<E> lambda) throws E {
    try {
        lambda.call();
    }
    catch(Throwable ex) {
        throw ex;
    }
}