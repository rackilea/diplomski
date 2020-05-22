public class WithSync extends Thread {
    public synchronized void add(int a) {
        for(int i=0;i<5;i++) {
        System.out.println(a*i);
        System.out.println(Thread.currentThread());
        }
    }
    public void run() {
        add(5);
    }


    public static void main(String[] args) {

    WithSync t1 = new WithSync();
    WithSync t2 = new WithSync();

    t1.start();  
    t2.start();
    }
}