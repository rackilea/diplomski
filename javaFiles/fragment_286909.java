try {
            jobj = new JSONObject(json);
        } catch (JSONException ex) {
            Log.d("Parsing Error!", "Can't parse the string" +ex.toString());
            Log.d("STRING_FROM_SERVER", json);
        }