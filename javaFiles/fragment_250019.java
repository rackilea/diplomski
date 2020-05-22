public static void main(String[] args) {
  Thread t1 = new Thread(new Runnable() {
    public void run() {
      synchronized (String.class) {
        System.out.println("Thread 1 after acquiring String lock");
        Thread.sleep(5000); // Sleep for 5 seconds
        synchronized (Integer.class) {
          System.out.println("Thread 1 after acquiring Integer lock");
        }
      }
    }
  });

  Thread t2 = new Thread(new Runnable() {
    public void run() {
      synchronized (Integer.class) {
        System.out.println("Thread 2 after acquiring Integer lock");
        Thread.sleep(5000); // Sleep for 5 seconds
        synchronized (String.class) {
          System.out.println("Thread 2 after acquiring String lock");
        }
      }
    }
  });

  t1.start();
  t2.start();
}