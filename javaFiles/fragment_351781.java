package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final StackPane root = new StackPane();
        final ProgressBar bar = new ProgressBar();
        final Image image = new Image( "https://farm8.staticflickr.com/7036/6952932649_3fc1cfeb8a_o_d.jpg", true );
        final ImageView imageView = new ImageView( image );
        final Text clip = new Text( "JavaFx" );
        final Scene scene = new Scene( root );

        root.setStyle( "-fx-background: pink;" );
        root.setEffect( new InnerShadow() );

        bar.prefWidthProperty().bind( root.widthProperty() );
        bar.visibleProperty().bind( Bindings.notEqual( 1, image.progressProperty() ) );
        bar.progressProperty().bind( image.progressProperty() );

        imageView.setFitWidth( 800 );
        imageView.setFitHeight( 600 );

        clip.setFont( Font.font( 144.0 ) );
    clip.setX( 400 - clip.getBoundsInLocal().getWidth() / 2 );
        clip.setY( 400 - clip.getBoundsInLocal().getHeight() / 2 );

        setInverseClip( imageView, clip );

        root.getChildren().add( bar );
        root.getChildren().add( imageView );

        primaryStage.setScene( scene );
        primaryStage.show();
}

    private void setInverseClip( final Node node, final Shape clip ) {
        final Rectangle inverse = new Rectangle();
        inverse.setWidth( node.getLayoutBounds().getWidth() );
        inverse.setHeight( node.getLayoutBounds().getHeight() );
        node.setClip( Shape.subtract( inverse, clip ) );
    }

    public static void main(final String[] args) {
        launch(args);
    }

}