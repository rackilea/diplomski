class MyObject { public volatile int shared; }


public void doSomethingWithObject(MyObject obj) {
    obj.shared = 1; // main() can see this
}