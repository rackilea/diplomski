public class MockJob implements IJob {

    private boolean cancelled;

    public MockJob() {
    }

    @Override
    public IResult execute() {
        int count = 0;
        while (!cancelled) {
            try {
                count++;
                System.out.println("Mock Job Thread: count = " + count);
                if (count >= 10) {
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                cancelled = true;
            }
        }
        return new MockResult(cancelled, count);
    }

    @Override
    public void cancel() {
        cancelled = true;
    }
}