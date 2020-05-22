ArrayList<String> listdata = new ArrayList<String>();     
JSONArray jArray = (JSONArray)jsonObject; 
if (jArray != null) { 
   for (int i=0;i<jArray.length();i++){ 
    listdata.add(jArray.get(i).toString());
   } 
}