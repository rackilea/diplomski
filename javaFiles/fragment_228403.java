public static Object lock = new Object();

 public void playTurn() {
    synchronized(lock) {
         //code
    }
}