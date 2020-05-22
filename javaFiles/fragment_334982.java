try {
                jsonString = "{ \"particles\":[" + jsonString + "] }" ;

                JSONObject jsonObject = new JSONObject(jsonString);

                JSONArray particles = jsonObject.getJSONArray("particles");

        for (int i = 0; i < particles.length(); i++) {
            JSONObject c = particles.getJSONObject(i);

            String id = c.getString("id");
            String sensorid = c.getString("sensorid");
            String pm1 = c.getString("pm1");
            String pm25 = c.getString("pm25");
            String pm10 = c.getString("pm10");
            String timestamp = c.getString("timestamp");

            HashMap<String, String> particle = new HashMap<>();
            particle.put("id", id);
            particle.put("sensorid", sensorid);
            particle.put("pm1", pm1);
            particle.put("pm25", pm25);
            particle.put("pm10", pm10);
            particle.put("timestamp", timestamp);

            Log.i("TAG Id", ":" + id);
            Log.i("TAG sensorid", ":" + sensorid);
            Log.i("TAG pm1", ":" + pm1);
            Log.i("TAG pm25", ":" + pm25);
            Log.i("TAG pm10", ":" + pm10);
            Log.i("TAG timestamp", ":" + timestamp);


        }
  }