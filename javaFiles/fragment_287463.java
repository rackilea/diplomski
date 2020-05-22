class AImpl<T extends IB<SomeGenericTypeIWantToUse>, SomeGenericTypeIWantToUse> implements IA<T> {

    ISomeModule<SomeGenericTypeIWantToUse> module;

    public void someMethod(T param) {
        SomeGenericTypeIWantToUse myVariable = param.anotherMethod();
        module.digest(myVariable);
    }
}