public class MyOverlay extends ItemizedOverlay<OverlayItem> {
    private Projection projection;
    private Point linePaint;
    private Vector<GeoPoint> points;
    public MyOverlay(Drawable defaultMarker) {
        points = new Vector<GeoPoint>()
        linePaint = new Paint();
        //set color, stroke width etc.
    }

    public void addPoint(GeoPoint point) {
        points.addElement(point);
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
        int size = points.size();
        Point lastPoint = new Point();
        projection.toPixels(points.get(0), lastPoint);
        Point point = new Point();
        for(int i = 1; i<size; i++){
            projection.toPixels(points.get(i), point);
            canvas.drawLine(lastPoint.x, lastPoint.y, point.x, point.y, linePaint);
            lastPoint = point;
        }
    }
 }