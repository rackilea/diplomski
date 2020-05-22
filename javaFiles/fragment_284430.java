package countdown;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.IntConsumer;

public class CountdownTimer {


    private IntConsumer secondsRemainingChangedHandler ;
    private Runnable onFinishedHandler ;

    private final Timer timer = new Timer();
    private int secondsRemaining ;

    public CountdownTimer(int totalSeconds) {
        this.secondsRemaining = totalSeconds ;
    }

    public void setSecondsRemainingChangedHandler(IntConsumer secondsRemainingChangedHandler) {
        this.secondsRemainingChangedHandler = secondsRemainingChangedHandler;
    }

    public void setOnFinishedHandler(Runnable onFinishedHandler) {
        this.onFinishedHandler = onFinishedHandler ;
    }

    private void tick() {
        secondsRemaining-- ;
        if (secondsRemainingChangedHandler != null) {
            secondsRemainingChangedHandler.accept(secondsRemaining);
        }
        if (secondsRemaining == 0) {
            timer.cancel();
            if (onFinishedHandler != null) {
                onFinishedHandler.run();
            }
        }
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, 1000, 1000);
    }
}