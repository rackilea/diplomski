HashMap<String, Object> params = new HashMap<String, Object>();
params.put("method","getProducts");

HashMap<String, String> methodParams = new HashMap<String, String>();
methodParams.put("currency", currency);

params.put("params", new JSONObject(methodParams));
restClient.setBodyValueForKey("json", new JSONObject(params).toString());