//------please try this instead of your while loop ----------
   JSONArray ar = new JSONArray();
   while (rs.next()){
         System.out.println("id "+rs.getString("our_game_id"));
         JsonObject updatemessage = new JsonObject();
         updatemessage.put("game_id", rs.getString("our_game_id"));
         updatemessage.put("date"   , rs.getString("dat"));
         ar.add(updatemessage);
   }

   if(ar.length()>0){
          System.out.println("provider "+ar.getString(0) );
   }