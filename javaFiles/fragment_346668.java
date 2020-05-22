import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.concurrent.*;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.*;

public class DrawLineIncrementalTest extends Application {
    private static final int FRAME_CALL_THRESHOLD = 25_000;

    private static final int ITERATIONS = 2;
    private static final double LINE_SPACING = 1;
    private final Random rand = new Random(666);
    private List<Color> colorList;
    private final WritableImage image = new WritableImage(ShapeService.W, ShapeService.H);

    private final Lock lock = new ReentrantLock();
    private final Condition rendered = lock.newCondition();
    private final ShapeService shapeService = new ShapeService();

    public DrawLineIncrementalTest() {
        colorList = new ArrayList<>(256);
        colorList.add(Color.ALICEBLUE);
        colorList.add(Color.ANTIQUEWHITE);
        colorList.add(Color.AQUA);
        colorList.add(Color.AQUAMARINE);
        colorList.add(Color.AZURE);
        colorList.add(Color.BEIGE);
        colorList.add(Color.BISQUE);
        colorList.add(Color.BLACK);
        colorList.add(Color.BLANCHEDALMOND);
        colorList.add(Color.BLUE);
        colorList.add(Color.BLUEVIOLET);
        colorList.add(Color.BROWN);
        colorList.add(Color.BURLYWOOD);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");

        System.out.println("Start testing...");
        new CanvasRedrawHandler().start();

        Button btn = new Button("test " + System.nanoTime());
        btn.setOnAction(e -> btn.setText("test " + System.nanoTime()));

        Scene scene = new Scene(new VBox(btn, new ImageView(image)));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class CanvasRedrawHandler extends AnimationTimer {
        long time = System.nanoTime();

        @Override
        public void handle(long now) {
            if (!shapeService.isRunning()) {
                shapeService.reset();
                shapeService.start();
            }

            if (lock.tryLock()) {
                try {
                    System.out.println("Rendering canvas");
                    shapeService.canvas.snapshot(null, image);
                    rendered.signal();
                } finally {
                    lock.unlock();
                }
            }

            long f = (System.nanoTime() - time) / 1000 / 1000;
            System.out.println("Time since last redraw " + f + " ms");
            time = System.nanoTime();
        }
    }

    private class ShapeService extends Service<Void> {
        private Canvas canvas;

        private static final int W = 1200, H = 800;

        public ShapeService() {
            canvas = new Canvas(W, H);
        }

        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    drawShapes(canvas.getGraphicsContext2D(), LINE_SPACING);

                    return null;
                }
            };
        }

        private void drawShapes(GraphicsContext gc, double f) throws InterruptedException {
            lock.lock();
            try {
                System.out.println(">>> BEGIN: drawShapes ");

                gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
                gc.setLineWidth(10);
                gc.setLineCap(StrokeLineCap.ROUND);

                long time = System.nanoTime();

                double w = gc.getCanvas().getWidth() - 80;
                double h = gc.getCanvas().getHeight() - 80;

                int nCalls = 0, nCallsPerFrame = 0;

                for (int i = 0; i < ITERATIONS; i++) {
                    for (double x = 0; x < w; x += f) {
                        for (double y = 0; y < h; y += f) {
                            gc.setStroke(colorList.get(rand.nextInt(colorList.size())));
                            gc.strokeLine(40 + x, 10 + y, 10 + x, 40 + y);
                            nCalls++;
                            nCallsPerFrame++;
                            if (nCallsPerFrame >= FRAME_CALL_THRESHOLD) {
                                System.out.println(">>> Pausing: drawShapes ");
                                rendered.await();
                                nCallsPerFrame = 0;
                                System.out.println(">>> Continuing: drawShapes ");
                            }
                        }
                    }
                }

                System.out.println("<<< END: drawShapes: " + ((System.nanoTime() - time) / 1000 / 1000) + "ms for " + nCalls + " ops");
            } finally {
                lock.unlock();
            }
        }
    }
}