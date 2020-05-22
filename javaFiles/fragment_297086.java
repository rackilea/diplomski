public static void main(String[] args) {
    System.out.println("main started");

    Thread t = new Thread(){
        public void run() {
            try {Thread.sleep(2000);} catch (InterruptedException consumeForNow) {}
            System.out.println("hello from run");
        };
    };
    t.run();

    System.out.println("main ended");
}