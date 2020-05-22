InvalidationListener resizeMediaView = observable -> {
    mediaView.setFitWidth(mediaViewPane.getWidth());
    mediaView.setFitHeight(mediaViewPane.getHeight());

    // After setting a big fit width and height, the layout bounds match the video size. Not sure why and this feels fragile.
    Bounds actualVideoSize = mediaView.getLayoutBounds();
    mediaView.setX((mediaView.getWidth() - actualVideoSize.getWidth()) / 2);
    mediaView.setY((mediaView.getHeight() - actualVideoSize.getHeight()) / 2);
};
mediaViewPane.heightProperty().addListener(resizeMediaView);
mediaViewPane.widthProperty().addListener(resizeMediaView);