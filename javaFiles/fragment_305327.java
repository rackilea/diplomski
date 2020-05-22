class DerivedClass implements MyInterface {

    private SuperClass sc;

    public String myMethod1() {
        return sc.myMethod();
    }

    public int myMethod() {
        return 0;
    }

}