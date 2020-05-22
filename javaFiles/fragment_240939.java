class MyFuncDelegate() {
    static void myFunc() {
        // your code
    }
}

class A {
    void myFunc() {
        super.myFunc();
        Delegate.myFunc();
    }
}