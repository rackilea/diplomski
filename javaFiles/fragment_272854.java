public class ExpensiveTask implements Callable<String> {

    private final String param;

    public ExpensiveTask(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        return expensiveMethod(param);
    }

}