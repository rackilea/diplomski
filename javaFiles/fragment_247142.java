JSONObject featureCollection = new JSONObject();
        featureCollection.put("type", "FeatureCollection");
        JSONObject properties = new JSONObject();
        properties.put("name", "ESPG:4326");
        JSONObject crs = new JSONObject();
        crs.put("type", "name");
        crs.put("properties", properties);
        featureCollection.put("crs", crs);

        JSONArray features = new JSONArray();



        // ciclo for
        for (PaqueteJson obj : paqueteService.findJson()) {
            JSONObject feature = new JSONObject();
            feature.put("type", "Feature");
            //JSONArray JSONArrayCoord = new JSONArray();
            JSONObject geometry = new JSONObject();
            JSONObject desc = new JSONObject();
            JSONObject newFeature = new JSONObject();


            //JSONArrayCoord.put(0, Double.parseDouble(obj.getLongitud()));
            //JSONArrayCoord.put(1, Double.parseDouble(obj.getLatitud()));
            JSONArray JSONArrayCoord = new JSONArray("[" + obj.getLongitud() + "," + obj.getLatitud() + "]");

            geometry.put("type", "Point");
            geometry.put("coordinates", JSONArrayCoord);
            feature.put("geometry", geometry);
            // proper.put("properties", desc);
            feature.put("properties", desc);
            desc.put("name", obj.getNombreEscaneo());


            features.put(feature);
            featureCollection.put("features", features);

            // System.out.println(featureCollection.toString());
            // }

        }
        System.out.println(featureCollection.toString());