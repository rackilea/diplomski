....

mapView.setStreetView(true);
mapView.setBuiltInZoomControls(true);
mapController = mapView.getController();
mapController.setZoom(14);

GoePoint initialPoint = new GeoPoint(some initial point);
double latitude = initialPoint .getLatitudeE6() / 1E6;
double longitude = initialPoint .getLongitudeE6() / 1E6;

Location location = new Location("initialLocation");
location.setLatitude(latitude);
location.setLongitude(longitude)
locationListener.onLocationChanged(location);
}