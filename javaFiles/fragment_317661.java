@Module
    public class MyModule {
        ...
        @Provides public SchedulerProvider provideSchedulerProvider() {
            return new SchedulerProvider() {
                @Override
                Scheduler getWorkerScheduler() {
                    return Schedulers.io();
                }

                @Override
                Scheduler getUiScheduler() {
                    return AndroidSchedulers.mainThread();
                }
            }
        }
    }