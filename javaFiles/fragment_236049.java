import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLight extends Application{

    private static final double RADIUS = 50;

    private Circle  circleRed,  circleYellow,  circleGreen;
    private Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN};
    private int onColor = 0;
    private static int threadNumber = 0, invokeThreadNumber =0;
    private static final Object myLock = new Object();

    @Override
    public void start(Stage primaryStage) {

        circleRed = new Circle(RADIUS);
        circleRed.setFill(Color.WHITE);
        circleGreen = new Circle(RADIUS);
        circleGreen.setFill(Color.WHITE);
        circleYellow = new Circle(RADIUS);
        circleYellow.setFill(Color.WHITE);

        TilePane light = new TilePane(circleGreen, circleYellow, circleRed);
        light.setPadding( new Insets(20, 20, 20, 20) );
        Scene scene = new Scene(light, RADIUS*8, RADIUS*3);

        primaryStage.setTitle("Traffic Light Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
        control();
    }

    private void control() {
        //invoke 3 synchronized control threads 
        new Thread( new ColorControl()).start();
        new Thread( new ColorControl()).start();
        new Thread( new ColorControl()).start();
    }

    private void update() {
        circleRed.setFill((onColor == 0) ?  colors[onColor] :Color.WHITE );
        circleYellow.setFill((onColor == 1) ? colors[onColor] :Color.WHITE);
        circleGreen.setFill((onColor == 2) ? colors[onColor] :Color.WHITE);
        onColor = ((onColor +1) >= colors.length) ? 0 : onColor+1;
    }

    class ColorControl implements Runnable {

        private int threadID;
        private static final long PAUSE = 1000;
        private int MAX_THREADS = 3;
        private boolean isStopped = false;

        ColorControl() {
            threadID = threadNumber ++;
        }

        void reset() {
            threadNumber = 0; invokeThreadNumber =0;
        }

        @Override
        public void run() {
            synchronized (myLock) {

                while (! isStopped  ) {
                    while (threadID != invokeThreadNumber) {
                        try {
                            myLock.wait();
                        } catch (InterruptedException e) {}
                    }
                    //do work here
                    update();

                    try {
                        Thread.sleep(PAUSE);
                    } catch (InterruptedException ex) { ex.printStackTrace();}
                    invokeThreadNumber++;
                    myLock.notifyAll();
                    if( invokeThreadNumber >= MAX_THREADS ) {
                        reset();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}