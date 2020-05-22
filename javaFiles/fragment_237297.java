public class MyThreadFactory1 implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return new MyThread1(r, "Peace");
        }
}