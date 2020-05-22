...
scaleBarOverlay = new ScaleBarOverlay(this.getBaseContext(), this, myMapView);
List<Overlay> overlays = myMapView.getOverlays();
// Add scale bar overlay
scaleBarOverlay.setMetric();
overlays.add(scaleBarOverlay);
...