httpPost.setHeader("Accept", "application/json");
httpPost.setHeader("Content-type", "application/json");

String json = "{ \"key\" : \"value\" }";
StringEntity entity = new StringEntity(json);
httpPost.setEntity(entity);