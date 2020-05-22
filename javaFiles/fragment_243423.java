public String getList() throws JSONException {
    List<User> data = member.getCurrentMembers() ;
    JSONArray array = new JSONArray();
    for (User u : data) {
        JSONObject datas = new JSONObject();
        datas.put("name", u.getUserName());
        datas.put("account", u.getAccount());
        datas.put("edit", u.getUserId());
        datas.put("id", u.getUserId());
        array.put(datas);
    }
    JSONObject result = new JSONObject();
    result.put("Data", array);
}