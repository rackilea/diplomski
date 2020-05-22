for(int i=0;i<exist_json_array_count;i++) {
        try {
            avr_hash = JArray.getJSONObject(i).getString("code");
            img_adress[i] = JArray.getJSONObject(i).getString("path");
        }catch (JSONException e){
            Log.e("Catch obj",e.toString());
        }