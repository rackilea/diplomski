final Kml kml = loadXMLFile("../data/Eemskanaal.kml");
private static Kml loadXMLFile(String path) {
        Kml kml = null;
        try {
            kml = Kml.unmarshal(path);
        } catch (RuntimeException ex) {
            kml = Kml.unmarshal(new File(path), false);
        }
        return kml;
    }