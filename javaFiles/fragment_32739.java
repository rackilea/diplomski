enum MyEnum implements MyInterface<Object> {
    MY_CLASS_1(new MyClass1()),
    MY_CLASS_2(new MyClass2());

    // you may also drop generics entirely: MyInterface delegate
    // and you won't need that cast in the constructor any more
    private final MyInterface<Object> delegate;

    MyEnum(MyInterface<?> delegate) {
        this.delegate = (MyInterface<Object>) delegate;
    }

    @Override
    public void run(Object e) {
        delegate.run(e);
    }
}