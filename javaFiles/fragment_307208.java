public class PointLayer extends TileRendererLayer {
    @Override
    public void draw(BoundingBox boundingBox, byte zoomLevel, Canvas canvas, Point canvasPosition) {
        super.draw(boundingBox, zoomLevel, canvas, canvasPosition);

        for (Point p : myPoints) {
            //pretty much use the circle code to draw the point
        }
    }
}