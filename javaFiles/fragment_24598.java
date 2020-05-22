String id = "{\"ID\":\"John Doe\"}";
id = id.replace(":","%3A");
String encodedID = URLEncoder.encode(id, "UTF-8").replace("+", "%20");
endpoint="https://127.0.0.1/getResourceNameToUse?id=" + encodedID;
HttpResponse response = new HttpResponse();
HttpGet httpget = new HttpGet(endpoint);
response = httpclient.execute(httpget, new RESTResponseHandler());