public String threadExample() {
    MyThread m1 = new MyThread();
    // I would not start in the thread constructor
    m1.start();
    m1.join();
    return m1.errors;
}