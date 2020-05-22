import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public class ShapedHTML extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Shape Text");
        Group circles = new Group();
        Circle circle = new Circle(50, Color.web("white", 0.7));
        circle.setCenterX(500.0f);
        circle.setCenterY(200.0f);
        circle.setStrokeType(StrokeType.OUTSIDE);
        circle.setStroke(Color.web("white", 0.16));
        circle.setStrokeWidth(4);
        circles.getChildren().add(circle);

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webView.maxWidthProperty().bind(circle.radiusProperty().multiply(2));
        webView.maxHeightProperty().bind(circle.radiusProperty().multiply(2));
        webEngine.documentProperty().addListener(observable -> {                   
            try {
                // Use reflection to retrieve the WebEngine's private 'page' field.
                Field f = webEngine.getClass().getDeclaredField("page");
                f.setAccessible(true);
                com.sun.webkit.WebPage page = (com.sun.webkit.WebPage) f.get(webEngine);
                page.setBackgroundColor((new java.awt.Color(0, 0, 0, 0)).getRGB());
            } catch (Exception e) {
                System.out.println("Difficulty to make WebView background transparent");
                e.printStackTrace();
            }
        });

        webEngine.loadContent("<h1 id='root' style='background : rgba(0,0,0,0); margin: 0; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);'>B<sub>0</sub></h1>");

        StackPane stack = new StackPane();
        stack.getChildren().addAll(circles, webView);

        Scene scene = new Scene(stack, 1000, 800, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}