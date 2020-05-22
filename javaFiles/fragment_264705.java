public boolean AddAtachment(String name, String id, String fileName, byte[] fileContent) throws IOException, JSONException
{
    DefaultHttpClient client = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(URL + "/_api/web/lists/GetByTitle('" + name + "')/items(" + id+ ")/AttachmentFiles/add(FileName='"+ fileName +"')");
    httpPost.setHeader("Cookie", "rtFa=" + RtFa + "; FedAuth=" + FedAuth);
    httpPost.setHeader( "X-RequestDigest", GetFormDigestValue());
    httpPost.setHeader("binaryStringRequestBody", "true");
    ByteArrayEntity entity = new ByteArrayEntity(fileContent);
    httpPost.setEntity(entity);
    HttpResponse response = client.execute(httpPost);
    return  response.getStatusLine().getStatusCode() == 200;
}