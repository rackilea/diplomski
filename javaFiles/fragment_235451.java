String jsonEntry =mySharedPreferences.getString("jsonEntry1",null);
if(jsonEntry != null){
    JSONArray completeArray = new JSONArray(jsonEntry);
    for (int i=0;i<completeArray .length();i++){
     JSONObject finalEntry=(JSONObject) completeArray .get(i);
       if(finalEntry.has("entry")){
        finalEntry.remove("entry");// for remove only one entry object you need to add your own logic 
       }  
    }
}