line.startXProperty().bind(
    source.layoutXProperty().add(
        source.widthProperty().divide(2)));
line.startYProperty().bind(
    source.layoutYProperty().add(
        source.heightProperty().divide(2)));