public class ExpensiveTask implements Callable<String> {

    @Override
    public String call() throws Exception {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Task completed";
    }
}