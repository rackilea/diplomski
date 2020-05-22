public static void main(String[] args) throws Exception {
    Runnable sleeper = new Runnable() {
        public void run() {
            try {
                System.out.println("sleeper is going to sleep");
                Thread.sleep(1000);
                System.out.println("sleeper is awake");
            } catch (InterruptedException e) {
                System.out.println("sleeper got interrupted");
            }
        }
    };

    Thread t = new Thread(sleeper);
    t.start(); //run sleeper in its own thread
    Thread.sleep(500); //sleeping in main a little to make sure t is started
    t.interrupt();
}