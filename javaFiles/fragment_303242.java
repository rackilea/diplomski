TextView text = new TextView(context);
text.setText(item.getTitle());
MapView.LayoutParams params = new MapView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.WRAP_CONTENT, item.getPoint(), MapView.LayoutParams.BOTTOM_CENTER);
params.mode = MapView.LayoutParams.MODE_MAP;
mMapView.addView(text, params);