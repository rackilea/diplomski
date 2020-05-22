import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.common.collect.Lists;
import com.google.common.math.IntMath;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        int numOfthreads = 2;
        List<String> originalList = new ArrayList<String>();

        for (int i = 0; i < 20; i++) {
            originalList.add(Integer.toString(i));
        }

        int partitionSize = IntMath.divide(originalList.size(), numOfthreads,
                RoundingMode.UP);
        List<List<String>> partitions = Lists.partition(originalList,
                partitionSize);
        List<Callable<Object>> todo = new ArrayList<Callable<Object>>();
        int count = 0;
        ExecutorService taskExecutor = Executors
                .newFixedThreadPool(numOfthreads);

        for (int i = 0; i < partitions.size(); i++) {
            TestThreads it = new TestThreads(partitions.get(i));

            todo.add(Executors.callable(it));
            System.out.println("Created thread " + count + ", containing: "
                    + partitions.get(i).size() + " files\n");
            for (String s : partitions.get(i)) {
                System.out.print(s + " ");
            }
            count++;
            System.out.println("\n");
        }

        taskExecutor.invokeAll(todo);

    }

    public static class TestThreads implements Runnable {
        private List<String> lis;

        public TestThreads(List<String> list) {
            lis = list;
        }

        public void run() {
            for (String s : lis) {
                System.out.println(Thread.currentThread().getId() + " : " + s);
            }
        }
    }
}