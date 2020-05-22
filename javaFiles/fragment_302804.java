public class Task3 implements Runnable {
    @Override public void run() {
        while (true) {
            final Integer i = queue.poll();
            if (i==null) break;    
            System.out.println(Thread.currentThread().getName() + " " + i);
            // process record # i
        }
    }
}