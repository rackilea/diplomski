@FXML
private void onMousePressed(MouseEvent me) {
    mousePosX = me.getSceneX();
    mousePosY = me.getSceneY();
    mouseOldX = me.getSceneX();
    mouseOldY = me.getSceneY();
}

@FXML
private void onMouseDragged(MouseEvent me) {
    mouseOldX = mousePosX;
    mouseOldY = mousePosY;
    mousePosX = me.getSceneX();
    mousePosY = me.getSceneY();
    ...
}