public static void main(String[] args) throws IOException {
    Thread main = Thread.currentThread();
    new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            System.out.println(main + " is in "+main.getState()+" state");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
    }).start();
    System.in.read();
}