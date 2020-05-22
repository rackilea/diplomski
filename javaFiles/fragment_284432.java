package countdown.gui;

import java.util.concurrent.CountDownLatch;

import countdown.CountdownTimer;
import javafx.concurrent.Task;

public class CountdownTask extends Task<Void> {

    private final int totalSeconds ;

    public CountdownTask(int totalSeconds) {
        this.totalSeconds = totalSeconds ;
    }

    @Override
    protected Void call() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        CountdownTimer timer = new CountdownTimer(totalSeconds);
        timer.setSecondsRemainingChangedHandler(t -> updateProgress(totalSeconds -t , totalSeconds));
        timer.setOnFinishedHandler(() -> latch.countDown());
        timer.start();
        latch.await();
        return null ;
    }
}