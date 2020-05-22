public static void main(String args[]) {
    final AtomicBoolean done = new AtomicBoolean(false);
    new Thread() {
        public void run() {
            done.set(true);
        }
    }.start();
    while (!done.get());
    System.out.println("bye");
}