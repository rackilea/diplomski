public class FakeExecutor implements Executor {

    @Override
    public void execute(Runnable task) {
        task.run();
    }
}