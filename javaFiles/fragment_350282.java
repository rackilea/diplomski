public class Mappin extends Overlay {

    protected Drawable drwMarker;
    protected GeoPoint gptCoordinates;

    public Mappin(Drawable drwMarker, GeoPoint gptCoordinates) {

        this.drwMarker = drwMarker;
        this.gptCoordinates = gptCoordinates;

    }

    @Override
    public void draw(Canvas canCanvas, MapView mapView, boolean booShadow) {

        super.draw(canCanvas, mapView, booShadow);

        Projection prjProjection = mapView.getProjection();

        Integer x;
        Integer y;

        if (!booShadow) {

            x = prjProjection.toPixels(gptCoordinates, null).x - (drwMarker.getIntrinsicWidth() / 2);
            y = prjProjection.toPixels(gptCoordinates, null).y - (drwMarker.getIntrinsicHeight());

        } else {

            Integer intSign = (SHADOW_X_SKEW > 0 ? 1 : -1);
            Float fltScaler = 1.1F - Math.abs(SHADOW_X_SKEW);
            x = (int) (prjProjection.toPixels(gptCoordinates, null).x - (intSign * (drwMarker.getIntrinsicWidth() * fltScaler)));
            y = (int) (prjProjection.toPixels(gptCoordinates, null).y - (drwMarker.getIntrinsicHeight() * SHADOW_Y_SCALE));

        }

        drawAt(canCanvas, drwMarker, x, y, booShadow);

    }

}