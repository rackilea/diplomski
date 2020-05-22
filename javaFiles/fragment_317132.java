JSONArray jsonArr = new JSONArray("[JSON Stirng]");
    List<Data> dataList = new ArrayList<>();
    for (int i = 0; i < jsonArr.length(); i++) {

        JSONObject jsonObj = jsonArr.getJSONObject(i);
        Data data = new Data();

        data.id = jsonObj.getString("id");
        data.operator = jsonObj.getString("operator");
        data.value = jsonObj.getString("value");

        dataList.add(data);
    }