BorderPane root = new BorderPane();
Scene scene = new Scene(root, 400, 400);
VBox seatHolder = new VBox(5);
seatHolder.setAlignment(Pos.CENTER);

// setup seatHolder as before but use 

root.setCenter(seatHolder);

HBox screenHolder = new HBox();
Rectangle screen = new Rectangle(350, 25);
screen.widthProperty().bind(seatHolder.widthProperty());
screen.setFill(Color.LIGHTSLATEGREY);
screenHolder.getChildren().add(screen);
screenHolder.setAlignment(Pos.BOTTOM_CENTER);
root.setBottom(screenHolder);
primaryStage.setScene(scene);
primaryStage.show();