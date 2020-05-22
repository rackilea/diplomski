import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    private static double SCENE_WIDTH = 1280;
    private static double SCENE_HEIGHT = 720;

    static Random random = new Random();

    Canvas canvas;
    GraphicsContext graphicsContext;

    AnimationTimer loop;

    Point2D mouseLocation = new Point2D( 0, 0);
    boolean mousePressed = false;
    Point2D prevMouseLocation = new Point2D( 0, 0);

    Scene scene;

    double brushMaxSize = 30;
    Image brush = createBrush( brushMaxSize, Color.CHOCOLATE);
    double brushWidthHalf = brush.getWidth() / 2.0;
    double brushHeightHalf = brush.getHeight() / 2.0;

    double pressure = 0;
    double pressureDelay = 0.04;

    private Image[] brushVariations = new Image[256];

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        canvas = new Canvas( SCENE_WIDTH, SCENE_HEIGHT);

        for( int i=0; i < brushVariations.length; i++) {

            double size = (brushMaxSize - 1) / (double) brushVariations.length  * (double) i + 1;

            brushVariations[i] = createBrush( size, Color.CHOCOLATE);
        }

        graphicsContext = canvas.getGraphicsContext2D();

        Pane layerPane = new Pane();

        layerPane.getChildren().addAll(canvas);

        root.setCenter(layerPane);

        scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

        addListeners();

        startAnimation();


    }

    private void startAnimation() {

        loop = new AnimationTimer() {

            @Override
            public void handle(long now) {

                if( mousePressed) {

                    // try this
                    // graphicsContext.drawImage( brush, mouseLocation.getX() - brushWidthHalf, mouseLocation.getY() - brushHeightHalf);

                    // then this
                    bresenhamLine( prevMouseLocation.getX(), prevMouseLocation.getY(), mouseLocation.getX(), mouseLocation.getY());

                    pressure += pressureDelay;
                    if( pressure > 1) {
                        pressure = 1;
                    }

                } else {

                    pressure = 0;

                }

                prevMouseLocation = new Point2D( mouseLocation.getX(), mouseLocation.getY());

            }
        };

        loop.start();

    }

    // https://de.wikipedia.org/wiki/Bresenham-Algorithmus
    private void bresenhamLine(double x0, double y0, double x1, double y1)
    {
      double dx =  Math.abs(x1-x0), sx = x0<x1 ? 1. : -1.;
      double dy = -Math.abs(y1-y0), sy = y0<y1 ? 1. : -1.;
      double err = dx+dy, e2; /* error value e_xy */

      while( true){

        int variation = (int) (pressure * (brushVariations.length - 1));
        Image brushVariation = brushVariations[ variation ];

        graphicsContext.setGlobalAlpha(pressure);
        graphicsContext.drawImage( brushVariation, x0 - brushWidthHalf, y0 - brushHeightHalf);

        if (x0==x1 && y0==y1) break;
        e2 = 2.*err;
        if (e2 > dy) { err += dy; x0 += sx; } /* e_xy+e_x > 0 */
        if (e2 < dx) { err += dx; y0 += sy; } /* e_xy+e_y < 0 */
      }
    }


    private void addListeners() {

        scene.addEventFilter(MouseEvent.ANY, e -> {

            mouseLocation = new Point2D(e.getX(), e.getY());

            mousePressed = e.isPrimaryButtonDown();

        });


    }


    public static Image createImage(Node node) {

        WritableImage wi;

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);

        int imageWidth = (int) node.getBoundsInLocal().getWidth();
        int imageHeight = (int) node.getBoundsInLocal().getHeight();

        wi = new WritableImage(imageWidth, imageHeight);
        node.snapshot(parameters, wi);

        return wi;

    }


    public static Image createBrush( double radius, Color color) {

        // create gradient image with given color
        Circle brush = new Circle(radius);

        RadialGradient gradient1 = new RadialGradient(0, 0, 0, 0, radius, false, CycleMethod.NO_CYCLE, new Stop(0, color.deriveColor(1, 1, 1, 0.3)), new Stop(1, color.deriveColor(1, 1, 1, 0)));

        brush.setFill(gradient1);

        // create image
        return createImage(brush);

    }


    public static void main(String[] args) {
        launch(args);
    }
}