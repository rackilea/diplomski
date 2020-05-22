public DraggablePieceIcon(Image image) {
    super(image);

    setOnMousePressed(event -> {
        mouseX = event.getSceneX();
        mouseY = event.getSceneY();

        // make cell containing this piece the top-most cell
        this.getParent().toFront()
    });

    ...
}