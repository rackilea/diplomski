/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication34;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class TracyAssignment2Chap14 extends Application {

    @Override
    public void start(Stage primaryStage) {
        double faceCenterX = 220.0;
        double faceCenterY = 220.0;
        double eyeYFromFaceCenter = 5.0;
        double eyeXFromFaceCenter = 80.0;
        double eyeBrowStartYFromFaceCenter = 40.0;
        double eyeBrowStartXFromFaceCenter = 40.0;
        double eyeBrowEndYFromFaceCenter = 70.0;
        double eyeBrowEndXFromFaceCenter = 80.0;

        Circle face = new Circle();
        face.setCenterX(faceCenterX);
        face.setCenterY(faceCenterY);
        face.setRadius(190.0);
        face.setFill(Color.YELLOW);
        face.setStrokeWidth(15.0);
        face.setStroke(Color.BLACK);

        Circle leftEye = new Circle();
        leftEye.setCenterX(faceCenterX - eyeXFromFaceCenter);
        leftEye.setCenterY(faceCenterY - eyeYFromFaceCenter);
        leftEye.setRadius(25.0);
        leftEye.setFill(Color.BLACK);

        Circle rightEye = new Circle();
        rightEye.setCenterX(faceCenterX + eyeXFromFaceCenter);
        rightEye.setCenterY(faceCenterY - eyeYFromFaceCenter);
        rightEye.setRadius(25.0);
        rightEye.setFill(Color.BLACK);

        Line leftEyebrow = new Line();
        leftEyebrow.setStartX(faceCenterX - eyeBrowStartXFromFaceCenter);
        leftEyebrow.setStartY(faceCenterY - eyeBrowStartYFromFaceCenter);
        leftEyebrow.setEndX(faceCenterX - eyeBrowEndXFromFaceCenter);
        leftEyebrow.setEndY(faceCenterY - eyeBrowEndYFromFaceCenter);
        leftEyebrow.setStrokeWidth(15.0);
        leftEyebrow.setStroke(Color.BLACK);

        Line RightEyebrow = new Line();
        RightEyebrow.setStartX(faceCenterX + eyeBrowStartXFromFaceCenter);
        RightEyebrow.setStartY(faceCenterY - eyeBrowStartYFromFaceCenter);
        RightEyebrow.setEndX(faceCenterX + eyeBrowEndXFromFaceCenter);
        RightEyebrow.setEndY(faceCenterY - eyeBrowEndYFromFaceCenter);
        RightEyebrow.setStrokeWidth(15.0);
        RightEyebrow.setStroke(Color.BLACK);

        Arc mouth = new Arc(faceCenterX, faceCenterY + 90, 80, 60, 0, 180);//(220,310,80,60,0,180);
        mouth.setFill(null);
        mouth.setStroke(Color.BLACK);
        mouth.setStrokeWidth(15.0);
        mouth.setType(ArcType.OPEN);

//   
        Group root = new Group(face, leftEye, rightEye, leftEyebrow, RightEyebrow, mouth);
        Scene scene = new Scene(root, 450, 450);
        primaryStage.setTitle("Emoji Assignment");
        ///scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        //add the scene to the stage
        primaryStage.setScene(scene);
        //show the contents of the stage 
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}