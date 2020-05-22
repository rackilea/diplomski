public class PathOverlay extends Overlay {

    private List<GeoPoint> mPositions;
    private Path mPath;
    private Paint mPathPaint;
    private Point mHelperPoint = new Point();

    public PathOverlay(List<GeoPoint> positions) {
        mPositions = positions;
        mPath = new Path();
        mPathPaint = new Paint();
        mPathPaint.setColor(0xDDA4C639);
        mPathPaint.setStyle(Paint.Style.STROKE);
        // add more path styling here
    }

    @Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
        if (shadow) {
            return; // path has no shadow
        }
        mPath.reset();
        boolean start = true;
        Point prev = new Point();
        for (Position p : mPositions) {
            mapView.getProjection().toPixels(p.geoPoint, mHelperPoint);
            if (start) {
                mPath.moveTo(mHelperPoint.x, mHelperPoint.y);
                prev.set(mHelperPoint.x, mHelperPoint.y);
                start = false;
            } else {
                int dx = prev.x - mHelperPoint.x;
                int dy = prev.y - mHelperPoint.y;
                mPath.lineTo(mHelperPoint.x, mHelperPoint.y);
                prev.set(mHelperPoint.x, mHelperPoint.y);
            }
        }
        canvas.drawPath(mPath, mPathPaint);
    }
}