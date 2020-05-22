import java.util.*;
import java.util.stream.*;
import java.util.concurrent.atomic.*;    
public class SumNumbers {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger threadNb = new AtomicInteger(5);
        AtomicInteger result = new AtomicInteger(0);
        List<Thread> threads = new LinkedList<>();
        IntStream.range(0, threadNb.intValue()).forEach(e -> {
            threads.add(new Thread(() -> {
                int sum = 0;
                int idx = e * 1000 + 1;
                while (!Thread.currentThread().isInterrupted()) {
                    if (idx <= (e + 1) * 1000) {
                        sum += idx++;
                    } else {
                        int r = result.addAndGet(sum);
                        System.out.println("sum found (job " + e + "); sum=" 
                        + sum + "; result=" + r 
                        + "; idx=" + idx);
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Job " + e + " done.");
                int threadNbVal = threadNb.decrementAndGet();
                System.out.println("Job " + e + " done, threadNb = " + threadNbVal);
            }));
        });
        threads.forEach(Thread::start);
        //noinspection StatementWithEmptyBody
        while(threadNb.intValue() > 0);
        System.out.println("result=" + result.intValue());
    }
}