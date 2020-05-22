import java.util.concurrent.CountDownLatch;

import javafx.application.Application;
import javafx.stage.Stage;

public class FXStarter extends Application {

    private static final CountDownLatch latch = new CountDownLatch(1);

    public static void awaitFXToolkit() throws InterruptedException {
       latch.await();
    }

    @Override
    public void init() {
        latch.countDown();
    }

    @Override
    public void start(Stage primaryStage) {
        // no-op
    }
}