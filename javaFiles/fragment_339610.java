/**
 * Formatter used by MyPieRenderer to draw a segment.
 */
class MySegmentFormatter extends SegmentFormatter {

    @Override
    public Class<? extends SeriesRenderer> getRendererClass() {
        return MyPieRenderer.class;
    } 

    @Override
    public SeriesRenderer getRendererInstance(final PieChart plot) {
        return new MyPieRenderer(plot);
    }       
}