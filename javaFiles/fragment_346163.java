String data = "[{\"key_11\": \"val_11\", \"key_12\": \"val_12\"}, {\"key_21\": \"val_21\", \"key_22\": \"val_22\"}]";
ObjectMapper mapper = new ObjectMapper();
Object[] objs = mapper.readValue(data, Object[].class);
System.out.println(objs[0].getClass().getName());

LinkedHashMap<String, Object> keyValues = (LinkedHashMap) objs[0];

System.out.println(keyValues.get("key_11"));