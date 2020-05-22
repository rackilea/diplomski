interface Interface<T extends Exception> {
    void method(List<String> list) throws T;
}
class ClassB implements Interface<Exception> {
    public void method(List<String> list) throws Exception {}
}