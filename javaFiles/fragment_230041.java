import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SomeRunnable implements Runnable {
    int threadNo = -1 ;
    List<String> list = new ArrayList<String>();
    public SomeRunnable(List list, int threadNo ) {
        this.list.addAll(list);
        this.threadNo =threadNo;
    }
    @Override
    public void run() {
        for (String element : list) {
            System.out.println("By Thread:" + threadNo+", Processed Element:" +element);
        }
    }

}

public class ExecutorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add("Elem:"+i);
        }
        // Divide list 
        int divideIndex = list.size()/2;
        //Create objects of Runnable
        SomeRunnable obj1 = new SomeRunnable(list.subList(0, divideIndex),1);
        SomeRunnable obj2 = new SomeRunnable(list.subList(divideIndex,list.size()),2);

        //Create fixed Thread pool, here pool of 2 thread will created
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(obj1);
        pool.execute(obj2);

        pool.shutdown();
    }

}