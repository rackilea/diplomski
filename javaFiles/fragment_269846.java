HashMap<String, Object> pair = new HashMap<>();
HashMap<String, Object> value = new HashMap<>();
List<Map<String, Object>> list = new ArrayList<>();

// set to empty value
list = new ArrayList<>();
ItemAPI.updateItemFieldValues(<itemId>, <fieldId>, list, <silent>, <hook>)

// set to real value
value = new HashMap<>();
list = new ArrayList<>();
pair.put("id", <user_id>);
pair.put("type", "user");
value.put("value", pair);
list.add(value);
ItemAPI.updateItemFieldValues(<itemId>, <fieldId>, list, <silent>, <hook>)