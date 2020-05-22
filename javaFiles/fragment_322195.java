try {            
         JSONObject jsonObject = null;
         yourJSONString.replace("\\", "");
         jsonObject = new JSONObject(yourJSONString);
         String newJSONString = jsonObject.get("GetCardsResult").toString();
         JSONArray jsonMainArr = new JSONArray(newJSONString);
         //now just loop the json Array
         for (int i = 0; i < jsonMainArr.length(); ++i) {                     
         JSONObject rec = jsonMainArr.getJSONObject(i);                     
         card.set_id(rec.get("ID").toString());                     
         //....      
       }                                                       
       } catch (JSONException e) {
         e.printStackTrace();
       }