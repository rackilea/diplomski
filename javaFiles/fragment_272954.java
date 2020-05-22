if(!SaveDialog.open) {
    boolean isSPressed = input.isKeyPressed(Input.Keys.S);
    if(!wasSpressed && isSPressed) {
        SaveDialog.Save(pixmap);
    }
    wasSPressed = isSPressed;
}