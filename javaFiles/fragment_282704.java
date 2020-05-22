Set<String> geoHashesForPolygon = GeoHashUtils.geoHashesForPolygon(points);
List<BoundingBox> bboxes = new ArrayList<>(geoHashesForPolygon.size());
for (String geoHash : geoHashesForPolygon) {
    double[] bbox = GeoHashUtils.decode_bbox(geoHash);
    bboxes.add(new BoundingBox(bbox));
}