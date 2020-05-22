public static final void main(String args[]) throws Exception {
    final Thread main = Thread.currentThread();
    Thread t = new Thread() {
        @Override
        public void run() {
            main.interrupt();
        }
    };
    t.start();
    t.join();
    Thread.sleep(1000);
    System.out.println("Not interrupted!");
}