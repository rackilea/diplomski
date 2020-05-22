try {
        JSONObject object = new JSONObject(all_items);
        JSONArray ja = object.getJSONObject("tree").getJSONArray("children");

 for (int k = 0; k < ja.size(); k++) {
          JSONObject lvlOne = ja.getJSONObject(k);
          JSONArray lvlOneArray = lvlOne.getJSONArray("children");

          for (int j = 0; j < lvlOneArray.size(); j++) {
              JSONObject lvlTwo = lvlOneArray.getJSONObject(i);
              JSONArray lvlTwoArray = lvlTwo.getJSONArray("children");

        for (int i = 0; i < lvlTwoArray.length(); i++) {
            JSONObject object1 = lvlTwoArray.getJSONObject(i);
            if (object1.has("name") && object1.has("percentage")) {
                System.out.println(object1.has("name"));//nothing gets printed
                HashMap<String, Object> tmp = new HashMap<>();
                tmp.put("name", object1.get("name"));
                tmp.put("percentage", object1.get("percentage"));
                array_list.add(tmp);

            }
        }
    }catch(JSONException e){
        e.printStackTrace();
    }