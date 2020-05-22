mapView = mapFragment.getView();
mapView.post(new Runnable() {
    @Override
    public void run() {
        int width = mapView.getMeasuredWidth();
        int height = mapView.getMeasuredHeight();

        String widthAndHeight = width + " " + height;
    }
});