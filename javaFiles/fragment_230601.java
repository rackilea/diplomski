GeoPoint tlGpt; // Top left (NW) Geopoint
GeoPoint brGpt; // Bottom right (SE) GeoPoint

GeoPoint trGpt; // Top right (NE) Geopoint
GeoPoint blGpt; // Bottom left (SW) GeoPoint

tlGpt = mapView.getProjection().fromPixels(0, 0);
brGpt = mapView.getProjection().fromPixels(mapView.getWidth(),
            mapView.getHeight());

trGpt = mapView.getProjection().fromPixels(mapView.getWidth(), 0);
blGpt = mapView.getProjection().fromPixels(0, mapView.getHeight());