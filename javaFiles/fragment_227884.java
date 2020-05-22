import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MySolution extends Application{

    List<Group> groups = new ArrayList<>();
    private Group  group;
    private Rectangle object ;
    private Pane pane;
    private double mousePointX;
    private double mousePointY;

    public static void main(String... arguments){ launch(arguments); }

    @Override public void start(Stage primaryStage){

        group = new Group();

        pane = new Pane(group);
        pane.setOnMousePressed(this::recordPosition);
        pane.setOnMouseDragged(this::makeShape);
        pane.setOnScroll(this::handleScroll);

        primaryStage.setScene(new Scene(new BorderPane(pane)));
        primaryStage.show();
    }

    //record mouse position
    private void recordPosition(MouseEvent event){
        mousePointX = event.getX();
        mousePointY = event.getY();
        object = new Rectangle(0, 0, Color.BLUE);
        object.setStroke(Color.BLACK);
        group.getChildren().addAll(object);
    }

    //method to make shape
    private void makeShape(MouseEvent event){
        if(object!=null){
            object.setTranslateX(mousePointX - group.getTranslateX());
            object.setTranslateY(mousePointY - group.getTranslateY());
            object.setHeight(event.getY() - mousePointY);
            object.setWidth(event.getX() - mousePointX);
        }
    }

    //method to control scroll
    private void handleScroll(ScrollEvent event){
        if(event.isControlDown()){
            zoom(Math.pow(1.01, event.getDeltaY()), event.getSceneX(), event.getSceneY());
        }else{
            group.setTranslateX(this.group.getTranslateX() + event.getDeltaX());
            group.setTranslateY(this.group.getTranslateY() + event.getDeltaY());
            for (Group g:groups) {
                g.setTranslateX(g.getTranslateX() + event.getDeltaX());
                g.setTranslateY(g.getTranslateY() + event.getDeltaY());
            }
        }
        event.consume();
    }

    //method to control zoom
    private void zoom(double factor, double x, double y){
        groups.add(group);
        for (Group g:groups) {
            double oldScale = g.getScaleX();
            double scale    = oldScale * factor;
            if(scale < 0.05) scale = 0.05;
            if(scale > 50) scale = 50;
            g.setScaleX(scale);
            g.setScaleY(scale);
            double f      = (scale / oldScale) - 1;
            Bounds bounds = g.localToScene(g.getBoundsInLocal());
            double dx     = (x - (bounds.getWidth() / 2 + bounds.getMinX()));
            double dy     = (y - (bounds.getHeight() / 2 + bounds.getMinY()));
            g.setTranslateX(g.getTranslateX() - f * dx);
            g.setTranslateY(g.getTranslateY() - f * dy);
        }
        group = new Group();
        pane.getChildren().add(group);
    }

}