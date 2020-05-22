private void NnormalMap()
{
        mapView = new MapView(this);

        mapView.setBuiltInZoomControls(false);
        mapView.setEnabled(true);
        mapView.setClickable(true);
        mapView.setFocusable(true);
        MapScaleBar mapScaleBar = mapView.getMapScaleBar();
        mapScaleBar.setShowMapScaleBar(true);


        mapView.addView(mRotateView);   //   if i use this 2 lines, the activity start with normal map ( no rotation)
        setContentView(mapView);
}