//Six replacement Picture Handler
// Load the image in the document and in the case of success attach it to the viewer
// Attach a replacement image to the pictures viewer
final int currentRow = row+2;
final OnLoadPreloadedImageHandler showNewImage = new OnLoadPreloadedImageHandler() {
    public void onLoad(PreloadedImage existingImage) {
        image.setWidth("75px");
        existingPanelImages.clear();
        existingPanelImages.add(existingImage);
        flexTable_Existing.setWidget(currentRow, 0, existingPanelImages);
        existingPanelImages.setSize("75px", "75px");
        existingPanelImages.setBorderWidth(1);
        existingPanelImages.setStyleName("gwt-TextBox");
        flexTable_Existing.getCellFormatter().setVerticalAlignment(currentRow, 0, HasVerticalAlignment.ALIGN_TOP);
        flexTable_Existing.getCellFormatter().setHorizontalAlignment(currentRow, 0, HasHorizontalAlignment.ALIGN_CENTER);
    }
};