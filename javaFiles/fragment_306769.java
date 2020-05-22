// deserialisation:
JSONObject json = GetJSONObjectFromNetWebService();

Poco item = new Poco();
item.id = json.getInt("Id");
item.name = json.GetString("Name");
item.dateValue = DateConverter.fromJSONString(json.getString("DateValue"));

// serialisation
JSONObject json = new JSONObject();

Poco item = GetPocoFromSomeWhereElse();
json.put("Id", item.id);
json.put("Name", item.name);
json.put("DateValue", DateConverter.toJSONString(item.dateValue));