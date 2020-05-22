JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(response);
            JSONObject jsonObject = (JSONObject) obj;
            //System.out.println(jsonObject.toString());
            System.out.println("json size==" + jsonObject.size());
            System.out.println("hghgfh" + jsonObject.keySet());
            JSONArray jsonArray = (JSONArray)jsonObject.get("responseObj");
            for(int i=0; i<jsonArray.size(); i++)
            {
                JSONObject arrayJsonObject  = (JSONObject) jsonArray.get(i);
                JSONObject assets = (JSONObject) arrayJsonObject.get("assets");
                // read the assets to store
            }
        }catch (Exception e){

        }