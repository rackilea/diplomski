public class MyTimer extends Timer {

        private final Object lock = new Object();
        private boolean canceled = false;

        @Override
        public void schedule(TimerTask task, long delay) {
            synchronize (lock) {
                super.schedule(task, delay);
                while (!cancelled) {
                    lock.wait();
                }
            }
        }

        // and more schedule overrides ...

        @Override
        public void cancel() {
            synchronize (lock) {
                super.cancel();
                canceled = true;
                lock.notifyAll();
            }
        }
    }