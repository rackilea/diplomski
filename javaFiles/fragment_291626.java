//this is where the transparency is achieved:
//the three layers must be made transparent
//(i)  make the VBox transparent (the 4th parameter is the alpha)
root.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
//(ii) set the scene fill to transparent
scene.setFill(null);
//(iii) set the stage background to transparent
stage.initStyle(TRANSPARENT);