public class PathOverlay extends Overlay{

    private List<GeoPoint> gpoints;

    public PathOverlay(List<GeoPoint> gpoints){
        this.gpoints = gpoints;
    }

    @Override
    public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) 
    {
        List<Point> mpoints = new ArrayList<Point>();

        // Convert to a point that can be drawn on the map.
        for(GeoPoint g : gpoints){
            Point tpoint = new Point();
            mapView.getProjection().toPixels(g, tpoint);
            mpoints.add(tpoint);
        }

        Path path = new Path();

        // Create a path from the points
        path.moveTo(mpoints.get(0).x, mpoints.get(0).y);
        for(Point p : mpoints){
            path.lineTo(p.x, p.y);
        }

        Paint paint = new Paint();
        paint.setARGB(255, 255, 0, 0);
        paint.setStyle(Style.STROKE);
        // Draw to the map
        canvas.drawPath(path,paint);

        return true;

    }
}