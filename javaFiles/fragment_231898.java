JSONParser json=new JSONParser();
        try {
        JSONArray   arr=(JSONArray)json.parse(str);         
        for (int i = 0; i < arr.size(); i++) {
            JSONObject obj=(JSONObject)arr.get(i); 
            System.out.println("ProjectID: "+obj.get("ProjectID"));
            System.out.println("ProjectName: "+obj.get("ProjectName"));
        } 
        } catch (ParseException e) {                
            e.printStackTrace();
        }