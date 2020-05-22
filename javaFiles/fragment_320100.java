// Use Firebase to convert to a Map<String,Object>
GenericTypeIndicator<Map<String,Object>> t = new GenericTypeIndicator<Map<String,Object>>() {};
Map<String,Object> map = dataSnap.getValue(t);

// Use Jackson to convert from a Map to an Office object
ObjectMapper mapper = new ObjectMapper();
Office pojo = mapper.convertValue(map, Office.class);