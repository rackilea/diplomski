private MapVeiw mMapView;

public CustomItemizedOverlay(Drawable defaultMarker, Context context, MapView mapView) {
    this(defaultMarker);
    this.context = context;
    this.mMapView = mapView;
}