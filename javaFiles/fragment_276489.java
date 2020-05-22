public static void main(String[] args) {
    final Timer timer = new Timer(true);
    timer.schedule(new TimerTask() {
        public void run() {
            System.out.println("hello");
        }
    }, 1);
    System.out.println("hi");
}