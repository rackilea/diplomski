import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CPUUsageChart extends Application {
    private static CPUUsageChart appInstance;

    private static final Lock lock = new ReentrantLock();
    private static final Condition appStarted = lock.newCondition();

    /**
     * Starts the application and records the instance.
     * Sets the JavaFX platform not to exit implicitly. 
     * (e.g. an explicit call to Platform.exit() is required
     *       to exit the JavaFX Platform).
     */
    @Override 
    public void start(Stage primaryStage) {
        lock.lock();

        try {
            Platform.setImplicitExit(false);
            appInstance = this;
            appStarted.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Get an instance of the application.
     * If the application has not already been launched it will be launched.
     * This method will block the calling thread until the
     * start method of the application has been invoked and the instance set. 
     * @return application instance (will not return null).
     */
    public static CPUUsageChart getInstance() throws InterruptedException {
        lock.lock();

        try {
            if (appInstance == null) {
                Thread launchThread = new Thread(
                        () -> launch(CPUUsageChart.class), 
                        "chart-launcher"
                );
                launchThread.setDaemon(true);
                launchThread.start();
                appStarted.await();
            }
        } finally {
            lock.unlock();
        }

        return appInstance;
    } 

    /**
     * Public method which can be called to perform the main operation 
     * for this application.
     * (render a chart and store the chart image to disk).
     * This method can safely be called from any thread.
     * Once this method is invoked, the data list should not be modified
     * off of the JavaFX application thread.
     */
    public void renderChart(
        ObservableList<XYChart.Data<Number, Number>> data
    ) {
        // ensure chart is rendered on the JavaFX application thread.
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(() -> this.renderChartImpl(data));
        } else {
            this.renderChartImpl(data);
        } 
    }

    /**
     * Private method which can be called to perform the main operation 
     * for this application.
     * (render a chart and store the chart image to disk).
     * This method must be invoked on the JavaFX application thread.
     */
    private void renderChartImpl(
        ObservableList<XYChart.Data<Number, Number>> data
    ) {
        LineChart<Number, Number> chart = new LineChart<>(
                new NumberAxis(),
                new NumberAxis(0, 100, 10)
        );
        chart.setAnimated(false);
        chart.getData().add(
                new XYChart.Series<>("CPU Usage", data)
        );

        Scene scene = new Scene(chart);

        try {
            LocalDateTime now = LocalDateTime.now();
            File file = Paths.get(
                    System.getProperty("user.dir"),
                    "cpu-usage-chart-" + now + ".png"
            ).toFile();
            ImageIO.write(
                    SwingFXUtils.fromFXImage(
                            chart.snapshot(null, null),
                            null
                    ),
                    "png",
                    file
            );

            System.out.println("Chart saved as: " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}