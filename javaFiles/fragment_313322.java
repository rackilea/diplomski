try {
            JSONObject jsobj = new JSONObject("your string goes here");
            JSONObject ppobj = jsobj.getJSONObject("pp");
            String status_marital_pmg = ppobj.getString("status_marital_pmg");
            Integer usia_pmg = ppobj.getInt("usia_pmg");
        } catch (JSONException e) {
        }