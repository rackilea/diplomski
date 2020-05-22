public static void main(String[] args) {
        // first create the child node
        JSONObject jObj2 = new JSONObject();
        jObj2.accumulate("id", 94);
        jObj2.accumulate("name", "Steve");
        jObj2.accumulate("children", new JSONArray());

        // then create the parent's children array
        JSONArray jA1 = new JSONArray(); 
        jA1.add(jObj2);

        // then create the parent
        JSONObject jObj1 = new JSONObject();
        jObj1.accumulate("id", 17);
        jObj1.accumulate("name", "Alex");
        jObj1.accumulate("children", jA1);

        // then create the main array
        JSONArray mainArray = new JSONArray();
        mainArray.add(jObj1);

        // then create the main object
        JSONObject mainObj = new JSONObject();
        mainObj.accumulate("ccgs", mainArray);

        System.out.println(mainObj);    
    }