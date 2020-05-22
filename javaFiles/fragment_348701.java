public void someMethod() {
    synchronized (list) {
        try {
            list.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}