pack();

Dimension dimPanels = panObjects.getSize();
Dimension dimWindow = this.getSize();
Dimension dimScroll = jScrollPane1.getSize();

int targetHeight = dimPanels.height - dimScroll.height + dimWindow.height;

if ((dimPanels.height > dimScroll.height) && (targetHeight < MAX_WINDOW_HEIGHT)) {
    this.setSize(dimWindow.width, targetHeight);
    validate();
}
else if (targetHeight > MAX_WINDOW_HEIGHT) {
    this.setSize(dimWindow.width, MAX_WINDOW_HEIGHT);
    validate();
}