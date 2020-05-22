import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable{

    final ScheduledExecutorService dhexceutors = Executors.newScheduledThreadPool(500);

    final static Random DHRANDOM = new Random();

    final long weight;

    public enum State {
        goDownhill,
        waitForLift,
        goUp,
        onTop,
    }

    private State state;

    public SkiLift lift; 

    public Client(long weight,SkiLift lift) {
        this.lift = lift;
        this.weight = weight;
        this.state = State.onTop;
        goDownHill();
    }

    private void enterLift() {
        lift.add(this);
    }


    private void goDownHill() {
        synchronized (this) {
            state = State.goDownhill;
            this.notify();
        }
        dhexceutors.schedule(() -> {
            liftStationReached();
        }, DHRANDOM.nextInt(500), TimeUnit.MILLISECONDS); 
    }

    public void liftStationReached() {
        synchronized(this) {
            state = State.waitForLift;
            this.notify();
        }
    }


    public void topReached() {
        synchronized(this) {
            state = State.onTop;
            this.notify();
        }
    }

    public void liftEntered() {
        synchronized(this) {
            state = State.goUp;
            this.notify();
        }
    }


    public void run() {
        synchronized(this) {
            while (true) {
                try {
                    this.wait();

                    switch (state) {
                    case waitForLift:
                        enterLift();
                        break;
                    case goUp: 
                        // just wait for the topReached event
                        break;
                    case goDownhill:
                        // just wait for reaching the lift.
                        break;
                    case onTop: 
                        goDownHill();
                        break;
                    }

                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}