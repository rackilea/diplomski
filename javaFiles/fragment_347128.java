public void createNewStage(Window parent) {
    //... all the other stuff
    Stage onTop = new Stage();
    onTop.initOwner(parent);
    onTop.initModality(Modality.WINDOW_MODAL);
    onTop.show();
}