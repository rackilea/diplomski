@Override
public void draw(android.graphics.Canvas canvas, MapView mapView, boolean shadow) {
    if (!shadow) {
        // Do your projection calculations here, if necessary

        for (int i = 0; i < mOverlays.size(); i++) {
            Drawable d = mOverlays.get(i).getMarker(0);
            d.setBounds(-width/2, -height/2, width/2, height/2);
        }
    }

    super.draw(canvas, mapView, shadow);
}