private static PointExtractor<LatLng> latLngPointExtractor =
        new PointExtractor<LatLng>() {

    @Override
    public double getX(LatLng point) {
        return point.getLat() * 1000000;
    }

    @Override
    public double getY(LatLng point) {
        return point.getLng() * 1000000;
    }
};