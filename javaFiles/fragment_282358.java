public class Command {

    private ExecutorService iExecutor;

    public Command(ExecutorService executor) {
        iExecutor = executor;
    }

    public void methodWithCallback(final int param1, final String param2, final ResultCallback callback) {
        iExecutor.execute(new Runnable() {
            @Override
            public void run() {
                // There are some calculations
                callback.onResult(param2);
            }
        });
    }
}