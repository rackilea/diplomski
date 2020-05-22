try {
    DefaultHttpClient httpclient = new DefaultHttpClient();
    File f = new File(filename);

    HttpPost httpost = new HttpPost("http://myremotehost:8080/upload/upload");
    MultipartEntity entity = new MultipartEntity();
    entity.addPart("myIdentifier", new StringBody("somevalue"));
    entity.addPart("myFile", new FileBody(f));
    httpost.setEntity(entity);

    HttpResponse response;

    response = httpclient.execute(httpost);

    Log.d("httpPost", "Login form get: " + response.getStatusLine());

    if (entity != null) {
        entity.consumeContent();
    }
    success = true;
} catch (Exception ex) {
    Log.d("FormReviewer", "Upload failed: " + ex.getMessage() +
        " Stacktrace: " + ex.getStackTrace());
    success = false;
} finally {
     mDebugHandler.post(mFinishUpload);
}