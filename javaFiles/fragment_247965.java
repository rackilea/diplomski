CloseableHttpResponse response = client.execute(request);

String res = null;

HttpEntity entity = response.getEntity();

if (entity != null) {

  InputStream instream = entity.getContent();

  byte[] bytes = IOUtils.toByteArray(instream);

  res = new String(bytes, "UTF-8");

  instream.close();

}

return res;