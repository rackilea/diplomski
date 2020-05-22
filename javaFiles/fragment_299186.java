class BaseClass<T> {
    public void show(Consumer<T> validationHandler) { //  or Consumer<? super T>
    }
}

class SubClass extends BaseClass<Protection> {
    @Override
    public void show(Consumer<Protection> validationHandler) { //  or Consumer<? super Protection>
        super.show(validationHandler);
    }
}

class Protection {}