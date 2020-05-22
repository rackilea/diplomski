File file = new File(pathname);

HttpClient httpclient = new DefaultHttpClient();
HttpPost httpPost = new HttpPost(restString);

FileBody uploadFilePart = new FileBody(file);
MultipartEntity reqEntity = new MultipartEntity();
reqEntity.addPart("template", uploadFilePart);
httpPost.setEntity(reqEntity);

HttpResponse response = httpclient.execute(httpPost);