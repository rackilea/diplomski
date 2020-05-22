String family = "Helvetica";
double size = 50;

TextFlow textFlow = new TextFlow();
textFlow.setLayoutX(40);
textFlow.setLayoutY(40);

// Red
Text text1 = new Text("Hello ");
text1.setFont(Font.font(family, size));
text1.setFill(Color.RED);

// Orange
Text text2 = new Text("Bold");
text2.setFill(Color.ORANGE);
text2.setFont(Font.font(family, FontWeight.BOLD, size));

// Green
Text text3 = new Text(" World");
text3.setFill(Color.GREEN);
text3.setFont(Font.font(family, FontPosture.ITALIC, size));

textFlow.getChildren().addAll(text1, text2, text3);

Group group = new Group(textFlow);
Scene scene = new Scene(group, 500, 150, Color.WHITE);
stage.setTitle("Hello Rich Text");
stage.setScene(scene);
stage.show();