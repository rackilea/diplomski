mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull final Style style) {
                     AddSanciangkoStreet(style);
                     SanciangkoStreetMarker();
             }
  }

private void AddSanciangkoStreet(@NonNull Style style) {
        style.addImage("sanciangko-street",
                BitmapUtils.getBitmapFromDrawable(getResources().getDrawable(R.drawable.floodicon)));

        style.addSource(new GeoJsonSource("sanciangkoFlood1-source-id"));

        style.addLayer(new SymbolLayer("sanciangkoFlood1-layer-id", "sanciangkoFlood1-source-id").withProperties(
                iconImage("sanciangko-street"),
                iconIgnorePlacement(true),
                iconAllowOverlap(true),
                iconSize(1f)
        ));
}

private void SanciangkoStreetMarker() {
        if (map.getStyle() != null) {
            GeoJsonSource sanciangkoFlood1 = map.getStyle().getSourceAs("sanciangkoFlood1-source-id");
            if (sanciangkoFlood1 != null) {
                sanciangkoFlood1.setGeoJson(FeatureCollection.fromFeature(
                        Feature.fromGeometry(Point.fromLngLat(123.895801, 10.297237))
                ));
            }
        }
}