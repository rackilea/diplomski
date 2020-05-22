public class MyClass {
    volatile int i = 1;
}

public class PrintOddAndEven extends Thread {

    MyClass lock;

    PrintOddAndEven(MyClass lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws Exception {
        MyClass obj = new MyClass();
        PrintOddAndEven odd = new PrintOddAndEven(obj);
        PrintOddAndEven even = new PrintOddAndEven(obj);
        odd.setName("Odd");
        even.setName("Even");
        odd.start();
        even.start();
    }

    @Override
    public void run() {
        while (lock.i <= 10) {
            if (lock.i % 2 == 0 && Thread.currentThread().getName().equals("Even")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - " + lock.i);
                    lock.i++;
                    lock.notify();
                }
            }
            if (lock.i % 2 == 1 && Thread.currentThread().getName().equals("Odd")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - " + lock.i);
                    lock.i++;

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}