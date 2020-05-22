String jsonString = "{\"results\":[{\"Flat_id\":\"1\",\"cat\":\"2\",\"Flat_no\":\"101\",\"Floor\":\"1\",\"Flat_type\":\"1 bhk\"},{\"Flat_id\":\"2\",\"cat\":\"2\",\"Flat_no\":\"102\",\"Floor\":\"1\",\"Flat_type\":\"2 bhk\"},{\"Flat_id\":\"3\",\"cat\":\"2\",\"Flat_no\":\"103\",\"Floor\":\"1\",\"Flat_type\":\"3 bhk\"},{\"Flat_id\":\"4\",\"cat\":\"2\",\"Flat_no\":\"104\",\"Floor\":\"1\",\"Flat_type\":\"1 rk\"},{\"Flat_id\":\"5\",\"cat\":\"2\",\"Flat_no\":\"201\",\"Floor\":\"2\",\"Flat_type\":\"1 bhk\",\"Floor plan\":\"http://vaserp.com/floor_plan/img1_1157img1_354454.png\"},{\"Flat_id\":\"6\",\"cat\":\"2\",\"Flat_no\":\"202\",\"Floor\":\"2\",\"Flat_type\":\"2 bhk\",\"Floor plan\":\"http://vaserp.com/floor_plan/img1_218706img1_1188632.png\"},{\"Flat_id\":\"7\",\"cat\":\"2\",\"Flat_no\":\"203\",\"Floor\":\"2\",\"Flat_type\":\"3 bhk\"},{\"Flat_id\":\"8\",\"cat\":\"2\",\"Flat_no\":\"204\",\"Floor\":\"2\",\"Flat_type\":\"1 rk\"}]}";
HashMap<String,Object> floorMap = new HashMap<String, Object>();
try{
     JSONObject responseJson =  new JSONObject(jsonString);
     JSONArray  resultJsonArray = responseJson.getJSONArray("results");

     for (int i=0;i<resultJsonArray.length();i++){
          if(floorMap.containsKey(resultJsonArray.getJSONObject(i).getString("Floor"))){
              ArrayList<HashMap<String,String>> flatList = (ArrayList<HashMap<String,String>>) floorMap.get(resultJsonArray.getJSONObject(i).getString("Floor"));
              HashMap<String,String> flatMap = new HashMap<String, String>();
              flatMap.put("Flat_id",resultJsonArray.getJSONObject(i).getString("Flat_id"));
              flatMap.put("Flat_no",resultJsonArray.getJSONObject(i).getString("Flat_no"));
              flatList.add(flatMap);
              floorMap.put(resultJsonArray.getJSONObject(i).getString("Floor"),flatList);
          }else{
              ArrayList<HashMap<String,String>> flatList = new ArrayList<HashMap<String, String>>();
              HashMap<String,String> flatMap = new HashMap<String, String>();
              flatMap.put("Flat_id",resultJsonArray.getJSONObject(i).getString("Flat_id"));
              flatMap.put("Flat_no",resultJsonArray.getJSONObject(i).getString("Flat_no"));
              flatList.add(flatMap);
              floorMap.put(resultJsonArray.getJSONObject(i).getString("Floor"),flatList);
          }
    }

}catch (Throwable e){
    e.printStackTrace();
}

Iterator it = floorMap.entrySet().iterator();
while (it.hasNext()) {
   Map.Entry pairs = (Map.Entry)it.next();
   System.out.print("Floor :: "+pairs.getKey());
   ArrayList<HashMap<String,String>> flatList = (ArrayList<HashMap<String,String>>) pairs.getValue();
   for(HashMap<String,String> flat : flatList){
       System.out.print("Flat_id :: "+flat.get("Flat_id"));
       System.out.print("Flat_no :: "+flat.get("Flat_no"));
   }
}