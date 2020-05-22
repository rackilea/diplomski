plot.setDomainAxis(new CategoryAxis() {
    @Override
    protected TextBlock createLabel(Comparable category, float width, RectangleEdge edge, Graphics2D g2) {
        TextBlock label = TextUtilities.createTextBlock(category.toString(), getTickLabelFont(category), getTickLabelPaint(category), width, this.getMaximumCategoryLabelLines(), new G2TextMeasurer(g2));
        label.setLineAlignment(HorizontalAlignment.LEFT);
        return label;
    }
});