public class Counter {
    int i = 1;

    public void add() {
        for (;;) {
            synchronized(this) {
                if (i > 5) { break; }
                System.out.println(i + " " + Thread.currentThread().getName());
                i++;
            }
        }
    }
}