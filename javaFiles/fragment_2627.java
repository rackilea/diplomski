import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author ggrec
 *
 */
public class DFXFlipPaneTester extends Application
{

    // ==================== 1. Static Fields ========================

    /*
     * Mmm... pie.
     */
    private static final Double PIE = Math.PI;

    private static final Double HALF_PIE = Math.PI / 2;

    private static final double ANIMATION_DURATION = 10000;

    private static final double ANIMATION_RATE = 10;


    // ====================== 2. Instance Fields =============================

    private Timeline animation;

    private StackPane flipPane;

    private SimpleDoubleProperty angle = new SimpleDoubleProperty(HALF_PIE);

    private PerspectiveTransform transform = new PerspectiveTransform();

    private SimpleBooleanProperty flippedProperty = new SimpleBooleanProperty(true);


    // ==================== 3. Static Methods ====================

    public static void main(final String[] args)
    {
        Application.launch(args);
    }


    // ==================== 5. Creators ====================

    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        primaryStage.setScene(new Scene(createFlipPane()));
        primaryStage.show();
    }

    private StackPane createFlipPane()
    {
        angle = createAngleProperty();

        flipPane = new StackPane();
        flipPane.setPadding(new Insets(30));

        flipPane.setMinHeight(500);
        flipPane.setMinWidth(500);

        flipPane.getChildren().setAll(createBackNode(), createFrontNode());

        flipPane.widthProperty().addListener(new ChangeListener<Number>() {

            @Override public void changed(final ObservableValue<? extends Number> arg0, final Number arg1, final Number arg2)
            {
                recalculateTransformation(angle.doubleValue());
            }
        });

        flipPane.heightProperty().addListener(new ChangeListener<Number>() {

            @Override public void changed(final ObservableValue<? extends Number> arg0, final Number arg1, final Number arg2)
            {
                recalculateTransformation(angle.doubleValue());
            }
        });

        return flipPane;
    }

    private StackPane createFrontNode()
    {
        final StackPane node = new StackPane();

        node.setEffect(transform);
        node.visibleProperty().bind(flippedProperty);

        node.getChildren().setAll(createButton("Front Button")); //$NON-NLS-1$

        return node;
    }

    private StackPane createBackNode()
    {
        final StackPane node = new StackPane();

        node.setEffect(transform);
        node.visibleProperty().bind(flippedProperty.not());

        node.getChildren().setAll(createButton("Back Button")); //$NON-NLS-1$

        return node;
    }

    private Button createButton(final String text)
    {
        final Button button = new Button(text);
        button.setMaxHeight(Double.MAX_VALUE);
        button.setMaxWidth(Double.MAX_VALUE);

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override public void handle(final ActionEvent arg0)
            {
                flip();
            }
        });

        return button;
    }

    private SimpleDoubleProperty createAngleProperty()
    {
        // --------------------- <Angle> -----------------------

        final SimpleDoubleProperty angle = new SimpleDoubleProperty(HALF_PIE);

        angle.addListener(new ChangeListener<Number>() {

            @Override public void changed(final ObservableValue<? extends Number> obsValue, final Number oldValue, final Number newValue)
            {
                recalculateTransformation(newValue.doubleValue());
            }
        });

        return angle;
    }

    private Timeline createAnimation()
    {
        return new Timeline(

                new KeyFrame(Duration.millis(0),    new KeyValue(angle, HALF_PIE)),

                new KeyFrame(Duration.millis(ANIMATION_DURATION / 2),  new KeyValue(angle, 0, Interpolator.EASE_IN)),

                new KeyFrame(Duration.millis(ANIMATION_DURATION / 2),  new EventHandler<ActionEvent>() {

                    @Override public void handle(final ActionEvent arg0)
                    {
                        // TODO -- Do they another way or API to do this?
                        flippedProperty.set( flippedProperty.not().get() );
                    }
                }),

                new KeyFrame(Duration.millis(ANIMATION_DURATION / 2),  new KeyValue(angle, PIE)),

                new KeyFrame(Duration.millis(ANIMATION_DURATION), new KeyValue(angle, HALF_PIE, Interpolator.EASE_OUT))

                );
    }


    // ==================== 6. Action Methods ====================

    private void flip()
    {
        if (animation == null)
            animation = createAnimation();

        animation.setRate( flippedProperty.get() ? ANIMATION_RATE : -ANIMATION_RATE );

        animation.play();
    }


    // ==================== 8. Business Methods ====================

    private void recalculateTransformation(final double angle)
    {
        final double insetsTop = flipPane.getInsets().getTop() * 2;
        final double insetsLeft = flipPane.getInsets().getLeft() * 2;

        final double radius = flipPane.widthProperty().subtract(insetsLeft).divide(2).doubleValue();
        final double height = flipPane.heightProperty().subtract(insetsTop).doubleValue();
        final double back = height / 10;

        /*
         * Compute transform.
         * 
         * Don't bother understanding these unless you're a math passionate.
         * 
         * You may Google "Affine Transformation - Rotation"
         */
        transform.setUlx(radius - Math.sin(angle) * radius);
        transform.setUly(0 - Math.cos(angle) * back);
        transform.setUrx(radius + Math.sin(angle) * radius);
        transform.setUry(0 + Math.cos(angle) * back);
        transform.setLrx(radius + Math.sin(angle) * radius);
        transform.setLry(height - Math.cos(angle) * back);
        transform.setLlx(radius - Math.sin(angle) * radius);
        transform.setLly(height + Math.cos(angle) * back);
    }

}