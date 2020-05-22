JSONParser jsonParser = new JSONParser();
                Object obj =  jsonParser.parse(new StringReader(str));
            if (obj instanceof JSONObject) {
                JSONObject jo = (JSONObject) obj;
                 System.out.println(jo.get("Debit").toString());
            } else {
                JSONArray ja = (JSONArray) obj;
                for(int i=0;i<ja.size();i++){
                    JSONObject   jsonObject = (JSONObject)ja.get(i);
                    System.out.println(jsonObject.get("Debit").toString());
                }
            }