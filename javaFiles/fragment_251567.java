try {
        JSONObject object = (JSONObject) new JSONTokener(JSONResponse)
                .nextValue();
        JSONArray earthquakes = object.getJSONArray("features");

        for (int i = 0; i < earthquakes.length(); i++) {
            JSONObject tmp = (JSONObject) earthquakes.get(i);
            //Log.i("JSON: ",tmp.toString());

            JSONObject geometry = tmp.getJSONObject("geometry");
            JSONArray coords = geometry.getJSONArray("coordinates");
            JSONObject properties = tmp.getJSONObject("properties");

            //Log.i("Data", "Coords:"+coords.getString(0) + " "+ coords.getString(1)+"\n Place:"+properties.getString("place")+ " Mag:"+properties.getString("mag"));

            if(coords.getString(0) != "" && coords.getString(1) != ""){
                result.add(new EarthQuakeRec(
                        Float.parseFloat(coords.getString(1)),//Lat
                        Float.parseFloat(coords.getString(0)),//Long
                        Float.parseFloat(properties.getString("mag")),//Magnitude
                        properties.getString("place")
                    )
                );
            }           
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }