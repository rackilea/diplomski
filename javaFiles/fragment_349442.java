fee.clear(); //<<<<
for(JsonElement obj : jArray )
   {
      FeePojo cse = gson.fromJson( obj , FeePojo.class);
       fee.add(cse);

   }