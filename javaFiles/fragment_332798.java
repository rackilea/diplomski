public class BrokenSync {
        private final Integer lock = 1;

        public void someMethod() {
            synchronized (lock) {
                // do something
            }
        }
    }