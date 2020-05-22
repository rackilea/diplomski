private void parseJSON(String response) {
   try{
       JSONObject value = new JSONObject(response);
       Log.d(" - - value - - ", value.toString());
       JSONArray items = value.getJSONArray("worldpopulation");
       Log.d(" - - items - - ", items.toString());
       for(int i=0;i<items.length();i++){

            JSONObject item = items.getJSONObject(i);
            Log.d(" - - item - - ", item.toString());
            ModelClass nm = new ModelClass();
            nm.setRank(item.optString("rank"));
            Log.d(" - - item.optString(rank) - - ", item.optString("rank").toString());
            nm.setCountry(item.optString("country"));
            nm.setPopulation(item.optString("population"));
            arrNews.add(nm);
        }
       }
       catch(Exception e){
           e.printStackTrace();
       }
}