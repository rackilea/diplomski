VBox root = new VBox();
root.setAlignment(Pos.TOP_CENTER);
final ProgressBar browser = new ProgressBar();
browser.prefWidthProperty().bind(root.widthProperty().subtract(20));  //  -20 is for 
   // padding from right and left, since we aligned it to TOP_CENTER.
root.getChildren().add(browser);