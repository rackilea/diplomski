private class ImageBackgroundCellRenderer extends CellRenderer {
    protected Image img;

    public ImageBackgroundCellRenderer(Cell modelElement, Image img) {
        super(modelElement);
        this.img = img;
    }

    @Override
    public void draw(DrawContext drawContext) {
        img.scaleToFit(getOccupiedAreaBBox().getWidth(), getOccupiedAreaBBox().getHeight());
        drawContext.getCanvas().addXObject(img.getXObject(), getOccupiedAreaBBox());
        super.draw(drawContext);
    }

    @Override
    public IRenderer getNextRenderer() {
        return new ImageBackgroundCellRenderer((Cell) modelElement, img);
    }
}