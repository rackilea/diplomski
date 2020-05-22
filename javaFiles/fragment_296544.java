InvalidationListener listener = o -> {
    double marg = (images.getWidth() - scrollPane.getViewportBounds().getWidth()) * scrollPane.getHvalue();
    posLbl.setTranslateX(marg);
    // posLbl.setPadding(new Insets(0, 0, 0, marg));
};

scrollPane.hvalueProperty().addListener(listener);
scrollPane.viewportBoundsProperty().addListener(listener);
listener.invalidated(null);