FileInputStream reader = new FileInputStream(args[0]);
        PullParser parser = new PullParser(new KMLConfiguration(), reader, SimpleFeature.class);

        FeatureJSON fjson = new FeatureJSON();
        FileWriter tmp = new FileWriter(args[0] + ".geojson");
        BufferedWriter writer = new BufferedWriter(tmp);
        ArrayList<SimpleFeature> features = new ArrayList<>();
        SimpleFeature simpleFeature = (SimpleFeature) parser.parse();
        while (simpleFeature != null) {
            System.out.println(simpleFeature);
            features.add(simpleFeature);
            simpleFeature = (SimpleFeature) parser.parse();
        }
        SimpleFeatureCollection fc = DataUtilities.collection(features);
        fjson.writeFeatureCollection(fc, System.out);