HBox hbox = new HBox();
Image img = new Image("main/img.png");
for (int i = 0; i < 4; i++) {
    ImageView iView = new ImageView(img);
    Pane pane = new StackPane(iView);
    pane.setStyle("-fx-background-color: yellow;");
    hbox.getChildren().add(pane);
}

ScrollPane scroller = new ScrollPane(hbox);
scroller.setPannable(true);
scroller.setFitToHeight(true);
scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

Group root = new Group(scroller);

// ...