String json = "{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\""
                + ",\"ppu\":0.55,\"batters\":{\"batter\":["
                + "{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\","
                + "\"type\":\"Chocolate\"},{\"id\":\"1003\","
                + "\"type\": \"Blueberry\" },{ \"id\": \"1004\", "
                + "\"type\": \"Devil's Food\" } ] },"
                + " \"topping\":["
                + "{ \"id\": \"5001\", \"type\": \"None\" },"
                + "{ \"id\": \"5002\", \"type\": \"Glazed\" },"
                + "{ \"id\": \"5005\", \"type\": \"Sugar\" },"
                + "{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },"
                + " { \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },"
                + "{ \"id\": \"5003\", \"type\": \"Chocolate\" },"
                + "{ \"id\": \"5004\", \"type\": \"Maple\" }]}";
        try {
            JSONObject root = new JSONObject(json);
            String id = root.getString("id");
            double dd = root.getDouble("ppu");

            System.out.println(""+id);
            System.out.println(""+dd);

            JSONObject batters=new JSONObject(root.getString("batters"));
            JSONArray batter=new JSONArray(batters.getString("batter"));

            for(int j=0;j<batter.length();j++){
                JSONObject navgt_batter=new JSONObject(batter.getString(j));
                 String id_batter= navgt_batter.getString("id");
                String type_batter=navgt_batter.getString("type");
                  System.out.println(""+id+" "+type_batter);
            }

            JSONArray topping=root.getJSONArray("topping");
             for(int k=0;k<topping.length();k++){
                 JSONObject navgt_batter=new JSONObject(topping.getString(k));
                 String id_top =navgt_batter.getString("id");
                String type_top=navgt_batter.getString("type");
                 System.out.println(""+id_top+" "+type_top);
             }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }