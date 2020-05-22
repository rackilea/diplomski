import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class ArcControl extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        CenteredArc centeredArc = new CenteredArc();
        ArcControls arcControls = new ArcControls(centeredArc.getArc());

        BorderPane layout = new BorderPane();
        layout.setCenter(centeredArc.getArcPane());
        layout.setBottom(arcControls.getControlPane());

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class CenteredArc {
    private static final double INSET = 10;

    private static final double ARC_RADIUS = 100;
    private static final double INITIAL_ARC_LENGTH  = 60;
    private static final double ARC_STROKE_WIDTH = 10;
    private static final double ARC_REGION_SIZE =
            ARC_RADIUS * 2 + ARC_STROKE_WIDTH + INSET * 2;

    private final Arc arc;
    private final Pane arcPane;

    public CenteredArc() {
        // Create the arc.
        arc = new Arc(
                ARC_REGION_SIZE / 2, ARC_REGION_SIZE / 2,
                ARC_RADIUS, ARC_RADIUS,
                0,
                INITIAL_ARC_LENGTH
        );
        arc.setStrokeWidth(10);
        arc.setStrokeLineCap(StrokeLineCap.ROUND);
        arc.setStroke(Color.FORESTGREEN);
        arc.setFill(Color.POWDERBLUE);

        // Create a background fill on which the arc will be centered.
        // The paint of the background fill can be set to Color.TRANSPARENT
        // if you don't want the fill to be seen.
        final double fillSize = ARC_RADIUS * 2 + arc.getStrokeWidth() + INSET * 2;
        Rectangle fill = new Rectangle(fillSize, fillSize, Color.PINK);

        // Place the fill and the arc in the group.
        // The Group will be a fixed sized matching the fill size.
        Group centeredArcGroup = new Group(fill, arc);

        // place the arc group in a StackPane so it is centered in a resizable region.
        arcPane = new StackPane(centeredArcGroup);
        arcPane.setPadding(new Insets(INSET));
        arcPane.setMinSize(0, 0);
        arcPane.setStyle("-fx-background-color: papayawhip;");
    }

    public Arc getArc() {
        return arc;
    }

    public Pane getArcPane() {
        return arcPane;
    }
}

// helper class which can use a slider to control an arc.
class ArcControls {
    private static final double INSET = 10;

    private final Slider slider;
    private final VBox controlPane;

    public ArcControls(Arc arc) {
        slider = new Slider(0, 360, arc.getLength());
        controlPane = new VBox(
                slider
        );
        controlPane.setPadding(
                new Insets(INSET)
        );
        controlPane.setStyle(
                "-fx-background-color: palegreen;"
        );

        arc.lengthProperty().bind(slider.valueProperty());
    }

    public Slider getSlider() {
        return slider;
    }

    public VBox getControlPane() {
        return controlPane;
    }
}