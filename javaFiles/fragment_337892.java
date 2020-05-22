sample.setOnMapReadyHandler(new MapReadyHandler() {
       @Override
       public void onMapReady(MapStatus status) {
          if (status == MapStatus.MAP_STATUS_OK) {
              final Map map = mapView.getMap();
              map.setCenter(new LatLng(35.91466, 10.312499));
              map.setZoom(2.0);
          }
       }
});