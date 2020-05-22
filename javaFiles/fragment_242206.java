private void configureListViewDragAndDrop(ListView<?> listView) {

    listView.setOnDragOver(event ->
    {
        Dragboard db = event.getDragboard();
        if (db.hasString())
        {
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    });

    listView.setOnDragDropped(event ->
    {
        Dragboard db = event.getDragboard();
        if (db.hasString() && dragSource.get() != null)
        {
            ListCell<Task> dragSourceCell = dragSource.get();
            listView.getItems().add(dragSourceCell.getItem());
            isDragSuccessful = true; // This is here beacuse the line under this one, doesn't work
            event.setDropCompleted(true);
            dragSource.set(null);
        } else
        {
            event.setDropCompleted(false);
        }
        event.consume();
    });

}