public byte[] executeBinary(URI uri) throws IOException, ClientProtocolException {
    HttpGet httpget = new HttpGet(uri);
    HttpResponse response = httpclient.execute(httpget);
    HttpEntity entity = response.getEntity();
    ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
    entity.writeTo(baos);
    return baos.toByteArray();
}