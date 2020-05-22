import java.util.Timer;
import java.util.TimerTask;

Timer timer = new Timer();

    Future<?> future = service.submit(new MyCallable());
    TimerTask controlTask = new TimerTask(){
        @Override
        public void run() {
            if (!future.isDone()) {
                future.cancel(true);
            }
        }       
    };
    long delay = 100;
    timer.schedule(task, delay);