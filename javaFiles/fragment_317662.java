public class TestModule extends MyModule {
        @Override public SchedulerProvider provideSchedulerProvider() {
            return new SchedulerProvider() {
                @Override
                Scheduler getScheduler() {
                    return Schedulers.trampoline();
                }

                @Override
                Scheduler getUiScheduler() {
                    return Schedulers.trampoline();
                }
            }
        }
    }