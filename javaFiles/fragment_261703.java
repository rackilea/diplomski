import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/** http://stackoverflow.com/questions/11886230/how-to-draw-a-crisp-opaque-hairline-in-javafx-2-2 */
public class LineWidths extends Application {
  public static void main(String[] args) { launch(args); }

  @Override public void start(Stage stage) {
    Line fuzzyline = LineBuilder.create()
        .startX(5).startY(50)
        .endX(90).endY(50)
        .stroke(Color.BLACK).strokeWidth(1)
      .build();
    Line hairline = LineBuilder.create()
        .startX(4.5).startY(99.5)
        .endX(89.5).endY(99.5)
        .stroke(Color.BLACK).strokeWidth(1)
      .build();
    Line fatline = LineBuilder.create()
        .startX(5).startY(150)
        .endX(90).endY(150)
        .stroke(Color.BLACK).strokeWidth(1).strokeType(StrokeType.OUTSIDE)
      .build();
    Pane snappedPane = new Pane();
    Line insideline = LineBuilder.create()
        .startX(5).startY(25)
        .endX(90).endY(25)
        .stroke(Color.BLACK).strokeWidth(1)
      .build();
    snappedPane.setSnapToPixel(true);
    snappedPane.getChildren().add(insideline);
    snappedPane.setPrefSize(100, 50);
    snappedPane.relocate(-0.5, 174.5);

    stage.setScene(
      new Scene(
        new Group(
          fuzzyline, hairline, fatline, snappedPane,
          new Text(10, 40, "fuzzyline"),  
          new Text(10, 90, "hairline"),  
          new Text(10, 140, "fatline"),  
          new Text(10, 190, "snappedPane")
        ), 100, 250
      )
    );
    stage.show();
  }
}