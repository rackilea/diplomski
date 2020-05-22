@Test
public void parseKml() {
    String src = "misctests/stackoverflow/kml/labasa.kml";
    try(InputStream is = getClass().getClassLoader().getResourceAsStream(src)) {
        Assert.assertNotNull(is);
        Kml kml = Kml.unmarshal(is);
        Feature feature = kml.getFeature();
        parseFeature(feature);
    }
}

private void parseFeature(Feature feature) {
    if(feature != null) {
        if(feature instanceof Document) {
            Document document = (Document) feature;
            List<Feature> featureList = document.getFeature();
            for(Feature documentFeature : featureList) {
                if(documentFeature instanceof Placemark) {
                    Placemark placemark = (Placemark) documentFeature;
                    Geometry geometry = placemark.getGeometry();
                    parseGeometry(geometry);
                }
            }
        }
    }
}

private void parseGeometry(Geometry geometry) {
    if(geometry != null) {
        if(geometry instanceof Polygon) {
            Polygon polygon = (Polygon) geometry;
            Boundary outerBoundaryIs = polygon.getOuterBoundaryIs();
            if(outerBoundaryIs != null) {
                LinearRing linearRing = outerBoundaryIs.getLinearRing();
                if(linearRing != null) {
                    List<Coordinate> coordinates = linearRing.getCoordinates();
                    if(coordinates != null) {
                        for(Coordinate coordinate : coordinates) {
                            parseCoordinate(coordinate);
                        }
                    }
                }
            }
        }
    }
}

private void parseCoordinate(Coordinate coordinate) {
    if(coordinate != null) {
        System.out.println("Longitude: " +  coordinate.getLongitude());
        System.out.println("Latitude : " +  coordinate.getLatitude());
        System.out.println("Altitude : " +  coordinate.getAltitude());
        System.out.println("");
    }
}