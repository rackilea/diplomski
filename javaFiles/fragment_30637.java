private static void loadButtonPanelButtons() {
    /* This button should tell the parent to bring up the save screen */
    TopButton save = new TopButton(buttonPanel,"Save") {
        public void triggerEvent() { parent.triggerSave(); }
    };
    save.setBorder(LineBorder.createBlackLineBorder());
    buttonPanel.add(save);

    /* This button should tell the parent to bring up the load screen */
    TopButton load = new TopButton(buttonPanel,"Load") {
        public void triggerEvent() { parent.triggerLoad(); }
    };
    load.setBorder(LineBorder.createBlackLineBorder());
    buttonPanel.add(load);

    TopButton addTile = new TopButton(buttonPanel,"Add Tile") {
        public void triggerEvent() { parent.triggerAddTile(); }
    };
    addTile.setBorder(LineBorder.createBlackLineBorder());
    buttonPanel.add(addTile);

    TopButton saveTiles = new TopButton(buttonPanel,"Save Tiles") {
        public void triggerEvent() { parent.triggerStyleSave(); }
    };
    saveTiles.setBorder(LineBorder.createBlackLineBorder());
    buttonPanel.add(saveTiles);
}