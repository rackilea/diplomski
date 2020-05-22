class MyClass {

    ...

    @Inject private MyOtherClassWrapper myOtherClassWrapper;

    ...

    public void myAPI() {
    ...
    String value = getMyOtherClassWrapper().decodeAndGetName();
    ...
    }

    private MyOtherClass getMyOtherClassWrapper() {
        return myOtherClassWrapper;
    }
}