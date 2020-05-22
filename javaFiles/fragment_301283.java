try {
        JSONArray data = new JSONArray(getJSONUrl(url));

        final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String,    String>>();
        HashMap<String, String> map;

        for(int i = 0; i < data.length(); i++){
            JSONObject c = data.getJSONObject(i);
            map = new HashMap<String, String>();
            map.put("V_ID", c.getString("V_ID"));
            map.put("V_Type", c.getString("V_Type"));
            map.put("V_Model", c.getString("V_Model"));
            map.put("V_Year", c.getString("V_Year"));
            map.put("V_Plate", c.getString("V_Plate"));
            map.put("ImagePath", c.getString("ImagePath"));
            map.put("Email", c.getString("Email"));

            String email = c.getString("Email");
              GlobalClass globalVariable = (GlobalClass) getApplicationContext();
              // Get name and email from global/application context
              final String Email  = globalVariable.getEmail();

             if(email.equals(Email))
            MyArrList.add(map);
        }