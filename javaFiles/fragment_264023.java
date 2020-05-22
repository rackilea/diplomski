import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndexError extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        List<Circle> views = new ArrayList<Circle>();
        for(int i = 1; i < 5; i++) {
            System.out.println("Adding circle at index " + (i -1));
            views.add(new Circle());
        }

        Random rand=new Random();
        int a,b;
        for(int k=1;k<5;k++){

            System.out.println("Getting circle at index " + k);

            a=rand.nextInt(400)+20;
            b=rand.nextInt(400)+20;

            views.get(k).setCenterX(a);
            views.get(k).setCenterY(b);
            views.get(k).setRadius(10);
            views.get(k).setFill(Color.DARKRED);

        }
        stage.setScene(new Scene(new Group(FXCollections.observableArrayList(views))));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}