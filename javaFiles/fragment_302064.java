JSONObject obj = new JSONObject(result);
   for(int i=1;i<=14;i++) {

        JSONArray arr = obj.optJSONArray(""+i);
        if(arr != null) {
              extraction(arr, i);
        }
   }