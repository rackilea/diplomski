JSONObject data = new JSONObject();
data.put("username", "test");
data.put("password", "password");
StringEntity entity = new StringEntity(data.toString(), HTTP.UTF_8);
httpPost.setEntity(entity);
// Making the call.
HttpResponse response = httpClient.execute(httpPost);