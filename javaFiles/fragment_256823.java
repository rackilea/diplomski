currentTile.setOnDragOver(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            Dragboard db = event.getDragboard();
            if (db.hasString()) {
                event.acceptTransferModes( TransferMode.COPY_OR_MOVE );
            }
            event.consume();
        }
    });