import java.util.concurrent.Semaphore;
public class Pi implements Runnable{
    static double pi = 0;
    static long numRects = 100;
    static int rectsPerThread = 1;
    static double width = 1.0 / numRects;
    long start, end;
    private static final Semaphore s = new Semaphore(1);

    public Pi(long start, long end){
        this.start = start;
        this.end = end; 
    }

    @Override
    public void run(){
        for(long i = start; i < end; i++){
            try{
                s.acquire();
            }catch (InterruptedException IE){ 
                return;
            }
            pi += Math.sqrt(1.0 - Math.pow(width * i, 2)) * width;
            s.release();
        }
    }

    public static void main(String[] args){
        Thread[] threads = new Thread[(int)(numRects / rectsPerThread)];
        double start = System.nanoTime();
        for(int i  = 0; i < threads.length; i++){
            threads[i] = new Thread(new Pi(i * rectsPerThread, i * rectsPerThread + rectsPerThread));
            threads[i].start();
        }

        for(Thread t : threads){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        pi *= 4;
        System.out.println(pi);
        System.out.printf("Ran in: %.4fms", (System.nanoTime() - start) / Math.pow(10, 6));
    }
}