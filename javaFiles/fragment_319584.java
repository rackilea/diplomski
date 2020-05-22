Map<String, Object> map = new HashMap<String, Object>();
map.put("returnedId", 0);
map.put("message", message);
// other paramters
mapper.insertRecord(map);
return map.get("returnedId");