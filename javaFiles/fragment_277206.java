public class ThreadA {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b){
            while (!b.isDone()) {
                System.out.println("Waiting for b to complete...");
                b.wait();
            }
            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;
    private boolean done = false;

    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            done = true;
            notify();
        }
    }

    public boolean isDone() {return done;}
}