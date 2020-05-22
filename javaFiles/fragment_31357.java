void method1() {
    synchronized (this) {
        method2()
    }
}

void method2() {
    synchronized (this) {
    }
}