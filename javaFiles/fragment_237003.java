for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = (JSONObject)jsonArray.get(i);  
            if(jsonObj.getString("type").equals("image") || jsonObj.getString("type").equals("text")) {  

                    String id =   jsonObj.getString("id");
                    String type = jsonObj.getString("type");
                    String data = jsonObj.getString("data");

                    contents.add(new SetRows(id, type, data));
                }
            }
            // the other stuff