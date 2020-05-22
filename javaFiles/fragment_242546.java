import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class SimpleThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<List> processor = new ExecutorCompletionService<List>(executor);


        //start loading data
        int procCount = 0;
        for (int i = 0; i < 10; i++) {
            Future loadData = processor.submit(new LoadData());
            procCount++;
        }
        //now all loading tasks have been submitted and are being executed
        System.out.println("All LOADING tasks have been submitted and are being executed");


        //new work queue using the same executor (or another one if you want more parallelism)
        ExecutorCompletionService<Void> converter = new ExecutorCompletionService<Void>(executor);

        while (procCount-- > 0) {
            Future<List> listOfDataFuture = processor.take(); //blocks until a 'LoadData' finishes
            System.out.println("A loading task just completed");
            List listOfData = listOfDataFuture.get();
            for (int i = 0; i < listOfData.size(); i++) {
                ConversionLogic conversion = new ConversionLogic(procCount + "_" + i);
                converter.submit(conversion);
            }
        }
        System.out.println("All LOADING tasks have been COMPLETED");

        //now all conversion tasks have been submitted and are being executed
        System.out.println("All CONVERSION task have been submitted and are being executed");

        /* You don't need to wait for conversion tasks to complete:
          * they will be completed nonetheless. Wait for them (with take())
          * if you need the results.
         * */    
        executor.shutdown();
        System.out.println(" End.");


    }
}

class LoadData implements Callable {

    public List call() throws Exception {

        List<String> dataList = new ArrayList<String>();

        for (int i = 0; i < 20; i++) {
            String data = "Data_" + i;
            System.out.println("Data Added in List:" + data);
            dataList.add(data);
        }
        Thread.sleep(2000);

        return dataList;
    }

}


class ConversionLogic implements Callable {

    private String threadName;

    public ConversionLogic(String threadName) {

        this.threadName = threadName;
    }

    @Override
    public Void call() throws Exception {
        try {

            System.out.println("Converting Data for Thread starts:" + threadName);
            Thread.sleep(1000);
            System.out.println("Converting Data for Thread ends:" + threadName);


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}