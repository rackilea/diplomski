@SuppressWarnings({"RawUseOfParameterizedType", "serial"})
private static class CustomTickMarkNumberAxis extends NumberAxis {
    private double[] customTicksSortedOnImportance;

    /**
     * A list ticks sorted after importance. In case of overlapping,
     * a higher ranked tick will trump a lower ranked tick, thus <i>not showing</i>
     * the lower ranked (overlapping) tick.
     * Other lower ranked ticks might still be shown, if they are not overlapping
     */
    public CustomTickMarkNumberAxis(double[] customTicksSortedOnImportance) {
        this.customTicksSortedOnImportance = customTicksSortedOnImportance;
    }

    protected List<NumberTick> refreshTicksVertical(Graphics2D g2, Rectangle2D dataArea, RectangleEdge edge) {
        List<NumberTick> result = new java.util.ArrayList<NumberTick>();

        //(... snip ...)

        Area tickLabelArea = new Area(); /** Used for overlap detection */
        for (int i = 0; i < customTicksSortedOnImportance.length; i++) {
            // The next lines of code are different from NumberAxis
            double currentTickValue = customTicksSortedOnImportance[i];
            currentTickValue = NumberUtil.round(currentTickValue, precision);

            //(... snip ...)

            /* Overlapping logic here */
            NumberTick numberTick = new NumberTick(currentTickValue, tickLabel, anchor, rotationAnchor, angle);
            Rectangle2D labelBounds = getTickBounds(numberTick, g2);
            double java2dValue = valueToJava2D(currentTickValue, g2.getClipBounds(), edge);
            labelBounds.setRect(labelBounds.getX(), java2dValue, labelBounds.getWidth(), labelBounds.getHeight());

            if (!tickLabelIsOverlapping(tickLabelArea, labelBounds)) {
                result.add(numberTick);
                tickLabelArea.add(new Area(labelBounds));
            }

            //(... snip ...)
        }
        return result;
    }

    private boolean tickLabelIsOverlapping(Area area, Rectangle2D rectangle) {
        return area.intersects(rectangle);
    }

    private Rectangle2D getTickBounds(NumberTick numberTick, Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics(getTickLabelFont());
        return TextUtilities.getTextBounds(numberTick.getText(), g2, fm);
    }
}