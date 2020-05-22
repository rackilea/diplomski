try {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray firstResult = jsonObject.getJSONArray("results");
        if (firstResult != null && firstResult.length() > 0) {
            for (int i=0; i<firstResult.length(); i++) {
                JSONObject result = firstResult.getJSONObject(i);
                // This is your effective_time; 
                String effective_time = result.getString("effective_time"); 
                JSONArray purpose = result.getJSONArray("purpose");
                if (purpose != null && purpose.length() > 0) {
                    for (int j=0; j<purpose.length(); j++) {
                        // This is the purpose;
                        String purposeData = purpose.getString(j); 
                    }
                }
            }
        }
    } catch (JSONException e) {
        e.printStackTrace();
}