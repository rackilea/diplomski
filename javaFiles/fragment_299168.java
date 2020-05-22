final MyClass tmp = new MyClass(SomeObject));
Thread t = new Thread(new Runnable() {
    @Override public void run() {
        tmp.doSomethingCleverWithString(someValueHere);
    }
});