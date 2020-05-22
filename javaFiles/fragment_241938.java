double sideSizeWidth = (anchorPane.getWidth()-bounds.getWidth());
    double sideSizeHeight= (anchorPane.getHeight()-bounds.getHeight());

    buffer.prefWidthProperty().bind(Bindings.add(
            chart.widthProperty(),
            -sideSizeWidth
    ));
    buffer.prefHeightProperty().bind(Bindings.add(
            chart.heightProperty(),
            -sideSizeHeight
    ));