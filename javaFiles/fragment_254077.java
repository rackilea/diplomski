import java.util.concurrent.*;

public class MakeAsynchronousCodeSynchronous {
    public static void main(String[] args) throws Exception {
        final Listener listener = new Listener();
        Runnable delayedTask = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Shouldn't be interrupted", e);
                }
                listener.onResult(123);

            }
        };
        System.out.println(System.currentTimeMillis() + ": Starting task");
        Executors.newSingleThreadExecutor().submit(delayedTask);
        System.out.println(System.currentTimeMillis() + ": Waiting for task to finish");
        while (!listener.isDone()) {
            Thread.sleep(100);
        }
        System.out.println(System.currentTimeMillis() + ": Task finished; result=" + listener.getResult());
    }

    private static class Listener {
        private Integer result;
        private boolean done;

        public void onResult(Integer result) {
            this.result = result;
            this.done = true;
        }

        public boolean isDone() {
            return done;
        }

        public Integer getResult() {
            return result;
        }
    }
}