MapController controller = mapView.getController();
controller.zoomToSpan(
        (maxLat - minLat),
        (maxLong - minLong));

controller.animateTo(new GeoPoint(
            (maxLat + minLat)/2,                 
            (maxLong + minLong)/2 ));