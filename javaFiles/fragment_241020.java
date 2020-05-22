import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.media.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;

public class TransformedVideo extends Application {
  public static void main(String[] args) throws Exception { launch(args); }
  @Override public void start(final Stage stage) throws Exception {
    final MediaPlayer oracleVid = new MediaPlayer(new Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv"));
    final MediaView mediaView = new MediaView(oracleVid);
    mediaView.setFitWidth(320); mediaView.setFitHeight(240); mediaView.setPreserveRatio(false);

    mediaView.setTranslateX(mediaView.getFitWidth()  / 2 + 200); 
    mediaView.setTranslateY(mediaView.getFitHeight() / 2 + 200);
    mediaView.setScaleX(2); mediaView.setScaleY(2);

// alternative method of scaling and translating.    
//    mediaView.getTransforms().addAll(
//      new Translate(200, 200),
//      new Scale(2, 2)
//    );

    Group group = new Group(mediaView);
    stage.setScene(new Scene(group, 1250, 800));
    stage.show();

    oracleVid.play();

    System.out.println(group.getBoundsInParent());
  }
}