public class TestSchedulerProvider implements SchedulerProvider {

    private final TestScheduler mIOScheduler = new TestScheduler();

    private final TestScheduler mMainThreadScheduler = new TestScheduler();

    @Override
    public TestScheduler io() {
        return mIOScheduler;
    }

    @Override
    public TestScheduler mainThread() {
        return mMainThreadScheduler;
    }
}