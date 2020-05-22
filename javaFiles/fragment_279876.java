@Test
public void upload_file_to_public_s3_with_httpClient() throws Exception {

    String fileName = "test.txt";
    String bucketName = "YOUR_BACKET_NAME";
    String s3url = "https://" + bucketName + ".s3.amazonaws.com/" + fileName;
    String body = "BODY OF THE FILE";

    HttpEntity entity = MultipartEntityBuilder
            .create()
            .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
            .addBinaryBody("file", body.getBytes())
            .build();

    HttpResponse returnResponse = Request.Put(s3url).body(entity).execute().returnResponse();
    StatusLine statusLine = returnResponse.getStatusLine();
    String responseStr = EntityUtils.toString(returnResponse.getEntity());
    log.debug("response from S3 : line: {}\n body {}\n ", statusLine, responseStr);
}