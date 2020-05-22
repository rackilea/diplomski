try {
            JSONArray json_Array = new JSONArray(response);
            for (int i=0;i<json_Array.length();i++) {
                 JSONObject json_data = json_Array.getJSONObject(i);
                boolean getFriendsError = json_data.getBoolean("error");
                if (!getFriendsError) {
                 ....
                }else{
                 ....
                }
                                                     }