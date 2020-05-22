class MyClass implements Runnable {
    ...
    MyClass start() {
        new Thread(this);
        return this;
    }
    ...
}

// Then construct like this:
MyClass foo = new MyClass().start();