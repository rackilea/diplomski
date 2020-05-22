ImageView imageView = new ImageView();
imageView.setFitWidth(256);
imageView.setFitHeight(256);
imageView.setImage(service.generateQR(256, 256));

ImageView overlay = new ImageView(
     new Image(getClass().getResourceAsStream("/icon.png")));
overlay.setFitWidth(80);
overlay.setFitHeight(80);

StackPane combinedQR = new StackPane(imageView, overlay);
...