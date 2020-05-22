public static void main(String[] args) {
    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        public void run() {
            System.out.println("hello");
            timer.cancel();
        }
    }, 1);
    System.out.println("hi");        
}