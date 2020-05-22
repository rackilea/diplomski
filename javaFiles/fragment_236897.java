public interface SchedulerProvider {

    Scheduler io();

    Scheduler mainThread();
}