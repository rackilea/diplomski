Type type = new TypeToken<Map<String, Object>>() {}.getType();
 Map<String, Object> data = new Gson().fromJson(jsonString, type);
 System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(data));
 // get the desired value from map

 Map<String,ArrayList<Map<String,String>>> mMap=(Map<String,ArrayList<Map<String,String>>>)data.get("M");
 ArrayList<Map<String,String>> rowArray=mMap.get("row");
 for(Map<String,String> colMap:rowArray){
     for(String value:colMap.values()){
         System.out.println(value);
     }
 }