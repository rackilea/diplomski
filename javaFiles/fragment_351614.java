public class OrderedPointPlacemark extends PointPlacemark {
    public OrderedPointPlacemark(Position position) {
        super(position);
    }
    @Override
    protected void makeOrderedRenderable(DrawContext dc) {
        super.makeOrderedRenderable(dc);

        if (this.intersectsFrustum(dc) || this.isDrawLine(dc)) {
            dc.pollOrderedRenderables();
            dc.addOrderedSurfaceRenderable(this);
        }
    }
}