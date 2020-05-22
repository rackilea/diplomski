AnchorPane anchorPane = new AnchorPane();
Image img = new Image(getClass().getResourceAsStream("Edit-Male-User-icon.png"));
ImageView imageView = new ImageView(img);
anch.getChildren().add(imageView );
ImageView app = (ImageView) (Node) anchorPane.getChildren().get(0);
app.setX(100);
app.setY(100);