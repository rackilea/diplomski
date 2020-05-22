for(int i=0;i<jsonArray.length;i++)
    {    
         JSONObject json_data = jArray.getJSONObject(i);
         imgnfo.id =  json_data.getInt("id_key");
         imgnfo.name = json_data.getString("name_key");
         imgnfo.thumb = json_data.getString("thumb_key");
         imgnfo.info = json_data.getString("info_key");
         myArray.add(new image_data());
    }