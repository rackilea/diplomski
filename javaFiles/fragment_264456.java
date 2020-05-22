import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Shapes extends Application {

    private Label label0, label1, label2, label3, label4;
    private TextField tField;

    private Circle circle1 ;
    private Circle circle2 ; 

    @Override
    public void start(Stage stage) {

        createTextField();
        VBox root = new VBox();
        root.setSpacing(10);
        Pane pane = new Pane();
        Color blue = new Color(1, 0, 0, 1);
        Color red = new Color(0, 0, 1, 1);
        circle1 = createCircle(50, 50, 50, red);
        circle2 = createCircle(50, 50, 200, blue);
        pane.getChildren().addAll(circle1, circle2);

        // If desired:

        // Rectangle clip = new Rectangle(0, 0, 0, 0);
        // clip.widthProperty().bind(pane.widthProperty());
        // clip.heightProperty().bind(pane.heightProperty());
        // pane.setClip(clip);


        root.getChildren().addAll(label0, label1, label2, tField, label3,
                label4, pane);
        Scene scene = new Scene(root, 1000, 1000);
        stage.setTitle("Spatial Relations Demo by");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


    public void createTextField() {
        label0 = new Label();
        label0.setText("Spatial Relations Demo");

        label1 = new Label();
        label1.setText("                              ");
        label1.setTextAlignment(TextAlignment.CENTER);

        label2 = new Label();
        label2.setText("Input Circles: x1 y1 r1 x2 y2 r2 ");
        label2.setTextAlignment(TextAlignment.CENTER);

        label3 = new Label();
        label3.setTextAlignment(TextAlignment.CENTER);

        label4 = new Label();
        label4.setTextAlignment(TextAlignment.CENTER);

        tField = new TextField();
        tField.setOnAction(new TextFieldHandler());
    }

    public class TextFieldHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            String str = tField.getText();
            int x1, y1, r1, x2, y2, r2;

            Scanner scanner = new Scanner(str);
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            r1 = scanner.nextInt();

            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            r2 = scanner.nextInt();

            circle1.setCenterX(x1);
            circle1.setCenterY(y1);
            circle1.setRadius(r1);
            circle2.setCenterX(x2);
            circle2.setCenterY(y2);
            circle2.setRadius(r2);

            tField.setText("");
            String str1 = String.format("Input is: " + x1 + " " + y1 + " " + r1
                    + " " + x2 + " " + y2 + " " + r2);
            label3.setText(str1);

            double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

            if ((x1 == x2) & (y1 == y2) & (r1 == r2))
                label4.setText(" The circles are equal.");
            else if (d >= (r1 + r2))
                label4.setText(" The circle interiors are disjoint.");
            else if (d <= (r2 - r1))
                label4.setText(" Circle1 is inside Circle2.");
            else if (d <= (r1 - r2))
                label4.setText(" Circle2 is inside Circle1.");
            else
                label4.setText(" The circles overlap.");

            scanner.close();
        }
    }

    public Circle createCircle(int x, int y, int r, Color color) {
        Circle circle = new Circle();
        circle.setRadius(r);
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setStroke(color);
        circle.setFill(null);

        return circle;
    }

}