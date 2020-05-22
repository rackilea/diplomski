fileField.setOnDragOver((e) -> {
    if (e.getGestureSource() != fileField && e.getDragboard().hasFiles()) {
        e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
    }
    e.consume();
});