import java.lang.InterruptedException;

public class ThreadRunner {
    public static void main(String[] args){
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB(a);

        b.start();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}

    }
}

class ThreadA extends Thread {
    String name = "threadA";

    public void run() {
        try {
            synchronized (this) {
                wait();
            }
            System.out.println(name + " " + "notified!");
        } catch(InterruptedException e) {
           // TODO: something
        }
    }
}

class ThreadB extends Thread {
    ThreadA a;
    String name = "threadB";

    public ThreadB(ThreadA a) {
        this.a = a;
    }

    @Override
    public void run(){

        a.start();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
        synchronized (a) {
            System.out.println(name + " " + "trying to notify A!");
            a.notify();
        }

    }
}