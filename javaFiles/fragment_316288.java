@FXML StackPane s;

@FXML void initialize(){

    BufferedImage b = ImageIO.read(file);
    Image i = SwingFXUtils.toFXImage(b, null);

    ImageView v = new ImageView(i);
    s.getChildren().add(v);
}