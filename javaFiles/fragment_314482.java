public class CustomInfoWindow extends MarkerInfoWindow {
    public CustomInfoWindow(MapView mapView) {
        super(my_own_layout, mapView);
    }
}

CustomInfoWindow myCustomInfoWindow = new CustomInfoWindow(mapView);