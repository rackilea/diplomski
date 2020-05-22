public class Solver {

    final long delay = 500L;

    String getSomeValue() {
        if (Math.random() < 0.8) return "not-null";
        return null;
    }

    void init() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(8);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                String value = getSomeValue();
                System.out.println("" + value + " " + System.currentTimeMillis());
                if (value != null) {
                    executor.schedule(this, delay - (System.currentTimeMillis() - time), TimeUnit.MILLISECONDS);
                }
            }
        };
        executor.schedule(runnable, delay, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        new Solver().init();
    }

}