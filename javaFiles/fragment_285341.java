boolean foundAnyRowHigherThan5 = false;
    for (line = reader.readLine(); line != null; line = reader.readLine()) {
        if (line.trim().length() > 0) { // skip blank lines
            String tokens[] = line.split("\\,");
            String name1 = tokens[0].trim();
            String name2 = tokens[1].trim();
            double latitude = Double.parseDouble(tokens[2]);
            double longitude = Double.parseDouble(tokens[3]);
            String name = tokens[4].trim();

            String speedString = tokens[5].trim();
            float speedFloat = Float.parseFloat(speedString);

          if(foundAnyRowHigherThan5 || speedFloat > 5.0) {
            // from this point forward, you will not skip lines based on speed.
            if(!foundAnyRowHigherThan5) {
              foundAnyRowHigherThan5 = true;
            }

            /* Longitude (= x coord) first ! */
            Point point = geometryFactory.createPoint(new Coordinate(longitude, latitude));

            featureBuilder.add(point);
            featureBuilder.add(name1);
            featureBuilder.add(name2);
            featureBuilder.add(name);
            featureBuilder.add(name4);
            SimpleFeature feature = featureBuilder.buildFeature(null);
            features.add(feature);
          }
       }
    }
} finally {
    reader.close();
}