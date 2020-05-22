public class Main {
    public static void main(String[] args) throws Exception {
        for(int i=0;i<10;i++){
            final int _i=i;
            Thread t = new Thread(new T(_i));
            t.start();
      }
    }
    public static class T implements Runnable{
        int threadNumber;
        public T(int threadNumber) {
            this.threadNumber=threadNumber;
        }

        @Override
        public void run() {
            increase(this);
        }
    }
    static Thread[] threads = new Thread[10];
    static int number  =0;
    static Object generalLock=new Object();
    public static void increase(T t){
        int myNumber=0;
        synchronized (generalLock){
            myNumber=number;
            System.out.println("i am "+number+" incrementing, my real number "+t.threadNumber);
            threads[number]=Thread.currentThread();
            number++;
        }
        while (threads[9]==null){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=9;i>myNumber;i--){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (generalLock){
            System.out.println("i am "+number+" decrementing, my real number "+t.threadNumber);
            number--;
        }
    }
}