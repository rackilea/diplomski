Map<String, Object> param = new HashMap<String, Object>();
List<String> obj = inputArrListObj;
param.put("1", "Value");
param.put("2", obj);
...
List<String> param2 = (List<String>) param.get("2");