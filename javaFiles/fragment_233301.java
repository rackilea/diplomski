import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solver implements Callable<Double> {

    private final AtomicBoolean running = new AtomicBoolean(true);

    public void stop() {
        this.running.set(true);
    }

    @Override
    public Double call() throws Exception {
        Double answer = null;
        while (this.running.get()) {
            answer = keepImproving();
        }
        // TODO Auto-generated method stub
        return answer;
    }

}

class Schedular extends TimerTask {

    private final Solver solver;

    public Schedular(Solver solver) {
        this.solver = solver;
    }

    @Override
    public void run() {
        this.solver.stop();
    }

}