HttpDelete deleteMethod = new HttpDelete(url);
deleteMethod.setHeader("Content-Length", "0");


HttpResponse httpResponse = client.execute(deleteMethod);
String responseContent = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");