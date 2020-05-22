public class Example {
    public static void main(String[] args) {
        for (int k = 0; k < 10; k++) {
            new TestThread(k).start();
        }
    }
}

class TestThread extends Thread {
    private final int k;

    TestThread(int k) {
        this.k = k;
    }

    @Override
    public void run() {
        System.out.print(k + " ");
    }
}