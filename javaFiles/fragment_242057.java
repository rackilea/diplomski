if (!leg.isEmpty()){
   for (int i = 0; i<leg.size();i++){
      for(int j=0;j<leg.get(i).size();j++)
         legDetails.add(leg.get(i).getJSONObject(j));
   }
}