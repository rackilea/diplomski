class Test {

    void method() {
        synchronized(this) {
        }
    }

    public static void main(String[] args) throws Exception {
        final Test t1 = new Test();
        new Thread() {
            public void run() {
                t1.method();
            };
        }.start();
        new Thread() {
            public void run() {
                t1.method();
            };
        }.start();
    }
}