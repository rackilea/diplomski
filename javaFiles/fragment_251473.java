BayeuxClient client = ...;
Map<String, Object> extraFields = new HashMap<>();
Map<String, Object> ext = new HashMap<>();
extraFields.put(Message.EXT_FIELD, ext);
Map<String, Object> extraData = new HashMap<>();
ext.put("com.acme", extraData);
client.handshake(extraFields);
extraData.put("token", "foobar");