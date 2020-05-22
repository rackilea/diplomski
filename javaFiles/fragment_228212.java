import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TransRotScal extends Application {

   @Override
   public void start( Stage primaryStage ) throws Exception {
      Pane pane = new Pane();
      pane.setScaleX( 10.0 );
      pane.setScaleY( 10.0 );
      pane.setRotate( theta );
      pane.setTranslateX( 468.0 );
      pane.setTranslateY( 152.0 );
      Polyline line = new Polyline( 10,20, 10,30, 50,30, 50,35 );
      line.setStroke( Color.DARKRED );
      Circle   c0   = new Circle( 10, 20, 2, Color.BLACK );
      Circle   c1   = new Circle( 10, 30, 2, Color.LIGHTSALMON );
      Circle   c2   = new Circle( 50, 30, 2, Color.LIGHTSALMON );
      Circle   c3   = new Circle( 50, 35, 2, Color.BLACK );
      Text     t0   = createText( 10, 20, "[10,20]", VPos.BOTTOM );
      Text     t1   = createText( 10, 30, "[10,30]", VPos.TOP );
      Text     t2   = createText( 50, 30, "[50,30]", VPos.BOTTOM );
      Text     t3   = createText( 50, 35, "[50,35]", VPos.TOP );
      pane.getChildren().addAll( line, c0, c1, c2, c3, t0, t1, t2, t3 );
      primaryStage.setScene( new Scene( pane ));
      primaryStage.centerOnScreen();
      primaryStage.setWidth ( 580 );
      primaryStage.setHeight( 280 );
      primaryStage.show();
   }

   private Text createText( int x, int y, String label, VPos vPos ) {
      Text text = new Text( x, y, label );
      text.setFill( Color.DARKGRAY );
      text.setFont( Font.font( Font.getDefault().getFamily(), 1.4 ));
      text.rotateProperty().set( -theta );
      text.textAlignmentProperty().setValue( TextAlignment.CENTER );
      text.setX( text.getX() - text.getBoundsInLocal().getWidth()/2.0);
      text.textOriginProperty().set( vPos );
      if( vPos == VPos.BOTTOM ) {
         text.setY( text.getY() - 2 );
      }
      else {
         text.setY( text.getY() + 2 );
      }
      return text;
   }

   private final double theta = Math.toDegrees( Math.atan2( -15.0, 40.0 ));

   public static void main( String[] args ) {
      launch();
   }
}