public class MyRunnable implements Runnable{

    String name = "DefaultName";

    public MyRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(String.valueOf(i) + "# My Name: " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(new MyRunnable("John"));
        pool.execute(new MyRunnable("Jimm"));
        pool.execute(new MyRunnable("Billy"));
        pool.shutdown();
    }
}