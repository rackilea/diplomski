static int total = 0;
public static void main(String[] args) {
    new Thread(() -> {
        for (int i = 0; i < 100000; i++) {
            total++;
            System.out.println("Thread 1 added! New total: " + total);
        }
    }).start();
    new Thread(() -> {
        for (int i = 0; i < 100000; i++) {
            total++;
            System.out.println("Thread 2 added! New total: " + total);
        }
    }).start();
}