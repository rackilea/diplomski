private void loadKml(File file) {

    try( InputStream inputstream = new FileInputStream(file) ) {

        // Set kmllayer to map
        // map is a GoogleMap, context is the Activity Context

        KmlLayer layer = new KmlLayer(map, inputstream, context);

        layer.addLayerToMap();



    // Handle these errors

    } catch (FileNotFoundException e) {

        e.printStackTrace();

    } catch (IOException e) {

        e.printStackTrace();

    } catch (XmlPullParserException e) {

        e.printStackTrace();
    }

}