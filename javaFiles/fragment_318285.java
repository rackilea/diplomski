class MyClass {
    public synchronized void methodA(MyClass mc) {
         mc.methodB();
    }

    public synchronized void methodB() {
         // something
    }
}

static MyClass MC1 = new MyClass(), MC2 = new MyClass();