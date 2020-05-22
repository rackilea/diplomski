class CustomTableRenderer extends TableRenderer {
    public CustomTableRenderer(Table modelElement) {
        super(modelElement);
    }

    @Override
    public IRenderer getNextRenderer() {
        return new CustomTableRenderer((Table)modelElement);
    }

    @Override
    public LayoutResult layout(LayoutContext layoutContext) {
        if (!isOriginalNonSplitRenderer) {
            LayoutArea area = layoutContext.getArea();
            area.setBBox(area.getBBox().decreaseHeight(100));
        }
        return super.layout(layoutContext);
    }
}