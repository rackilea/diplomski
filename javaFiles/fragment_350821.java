import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadToRun implements Runnable {
    List<Integer> list;
    private int[] array;

    public ThreadToRun(int[] array, List<Integer> list) {
        this.array = array;
        this.list = list;
    }

    public void run() {
        for (int array : a) {
            list.add(array);
        }
    }
}


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunThreads {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        int[] numbers1 = {0, 2, 4, 6, 8};
        int[] numbers2 = {1, 3, 5, 7, 9};

        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

        ThreadToRun t1 = new ThreadToRun(numbers1, list);
        ThreadToRun t2 = new ThreadToRun(numbers1, list);

        executor.execute(t1);
        executor.execute(t2);
        executor.shutdown();

        // print the list out
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " found at location ("+i+")");
        }
    }
}