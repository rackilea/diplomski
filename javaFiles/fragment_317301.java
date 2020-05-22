for (int i = 0; i < 10; i++) {
    for (int t = 0; t < 10; t++) {
         Image image = new Image("https://s3.amazonaws.com/media.eremedia.com/uploads/2012/08/24111405/stackoverflow-logo-700x467.png");
         ImageView imageView = new ImageView(image);
         imageView.fitHeightProperty().bind(centerRoot.heightProperty().subtract(100).divide(10));
         imageView.fitWidthProperty().bind(centerRoot.widthProperty().subtract(100).divide(10));
         imageView.setPreserveRatio(false);
         centerRoot.add(imageView, i, t);
     }
 }