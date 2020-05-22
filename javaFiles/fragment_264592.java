HttpResponse response = httpClient.execute(httpGet, localContext);
HttpEntity entity = response.getEntity();
Object content = EntityUtils.toString(entity);
JSONObject jsonObj = new JSONObject(content.toString());

System.out.print("message is"+jsonObj.toString());