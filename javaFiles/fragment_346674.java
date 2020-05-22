package skowronek15;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;



public class DrawLineWithArrowKeys extends Application {
double bX = 150; //start x value denote for beginning-X
double bY = 150; //start y value denote for beginning-y
double eX = 150; //start x value denote for end-x
double eY = 150; //start y value denote for end-y
double bX2, bY2; //start of next line
double segment = 20; //length of segment


@Override
public void start(Stage primaryStage) {
    Pane myPane = new Pane(); //create a pane


    Line line = new Line(bX,bY,eX,eY); //create the starting or initial line
    line.setStrokeWidth(2); //set width
    line.setStroke(Color.RED); //set color
    myPane.getChildren().add(line); //add line to pane

    line.setOnKeyPressed(e -> { //switch statement to determine what happens when
                                // each key is pressed
     if (e.getCode().isArrowKey())
     {
        switch (e.getCode()) {

        case DOWN:
            bY2 = bY ; //start of next line, bY2 is equal to the start of originating
                       // y-coordinate bY
            bY += segment;//increment start of first line
            eY = bY; // end y (eY) coordinate equal to beginning y coordinate (bY) after 
                    // it's incremented;


            Line line2 = new Line(bX,bY2,eX,eY); //create a new line to be drawn;
                                //beginning y coordinate is now bY2;
            line2.setStrokeWidth(2);
            line2.setStroke(Color.GREEN);
            myPane.getChildren().add(line2);
            break;

        case UP:
            bY2 = bY;
            bY -= segment;
            eY = bY;

            Line line3 = new Line(bX,bY2,eX,eY);
            line3.setStrokeWidth(2);
            line3.setStroke(Color.GREEN);
            myPane.getChildren().add(line3);
            break;

        case LEFT:
            bX2 = bX;
            bX -= segment;
            eX = bX;

            Line line4 = new Line(bX2,bY, eX, eY);
            line4.setStrokeWidth(2);
            line4.setStroke(Color.GREEN);
            myPane.getChildren().add(line4);
            break;

        case RIGHT: 
            bX2 = bX;
            bX += segment;
            eX = bX;
            Line line5 = new Line(bX2,bY,eX,eY);
            line5.setStrokeWidth(2);
            line5.setStroke(Color.GREEN);
            myPane.getChildren().add(line5);
            line5.getStrokeLineJoin();
            break;

            default:


            break;
        }
     }
    });


    Scene scene = new Scene(myPane, 300, 300);
    primaryStage.setTitle("Draw Line with Arrow Keys");
    primaryStage.setScene(scene);
    primaryStage.show();
    line.requestFocus();



}






public static void main(String[] args) {
    launch(args);
}