public class SchedulerProviderImpl implements SchedulerProvider {

    public static final SchedulerProvider INSTANCE = new SchedulerProviderImpl();

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }
}