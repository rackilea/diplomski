JSONArray jsonArr = new JSONArray("[your JSON Stirng]");
    List<Data> dataList = new ArrayList<Data>();
    for (int i = 0; i < jsonArr.length(); i++) {
        JSONObject jsonObj = jsonArr.getJSONObject(i);
        Data data = new Data();
        data.setId(jsonObj.getString("id"));
        data.setTitle(jsonObj.getString("title"));
        data.setDescription(jsonObj.getString("description"));
        data.setUserId(jsonObj.getString("user_id"));
        dataList.add(data);
    }