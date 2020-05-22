Set<String> stationCodes=new HashSet<String>();
JSONArray tempArray=new JSONArray();
for(int i=0;i<yourJSONArray.size();i++){
   String  stationCode=yourJSONArray.getJSONObject(i).getString("stationCode");
   if(stationsCodes.contains(stationCode){
     continue;
   }
   else{
      stationsCodes.add(stationCode);
      tempArray.add(yourJSONArray.getJSONObject(i));
   }

}


yourJSONArray= tempArray; //assign temp to original

//here how you can sort it using utility above:
JSONArraySort.sortASCE(yourJSONArray,"distance");