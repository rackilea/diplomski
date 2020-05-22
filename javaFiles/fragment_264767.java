List<HashMap<String,String> maps = new ArrayList();
while (resultSet.next()) {
    HashMap<String, String> data = new HashMap<String, String>();
    data.put("slot_name", resultSet.getString("name"));
    data.put("data", resultSet.getString("param_value"));
    maps.add(data);
}