double padding = ... ;

imageView.setPreserveRatio(true);
imageView.fitWidthProperty().bind(
    Bindings.min(stackPane.widthProperty().subtract(padding), image.widthProperty()));
imageView.fitHeightProperty().bind(
    Bindings.min(stackPane.heightProperty().subtract(padding), image.heightProperty()));